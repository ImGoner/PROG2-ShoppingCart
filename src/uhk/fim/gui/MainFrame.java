package uhk.fim.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JButton btnPridej;
    JButton btnDelete;
    JTextField txtInputName,txtInputCenaKus,txtInputPocetKusu;

    public MainFrame(int width, int height) {
        super("super");

        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();
    }

    public void initGUI() {
        JPanel panelMain = new JPanel(new BorderLayout());

        JPanel panelTable = new JPanel();
        JPanel panelFooter = new JPanel();
        JPanel panelInputs = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel lblInput = new JLabel("Nazev");
        panelInputs.add(lblInput);

        txtInputName  = new JTextField("Nazev", 15);
        panelInputs.add(txtInputName);

        JLabel lblCenaKus = new JLabel("Cena/Kus");
        panelInputs.add(lblCenaKus);

        txtInputCenaKus  = new JTextField("Cena/Kus", 10);
        panelInputs.add(txtInputCenaKus);

        JLabel lblPocetKusu = new JLabel("Pocet kusu");
        panelInputs.add(lblPocetKusu);

        txtInputPocetKusu  = new JTextField("Pocet kusu", 10);
        panelInputs.add(txtInputPocetKusu);

        btnPridej = new JButton("Pridat");
        btnPridej.addActionListener(this);
        panelInputs.add(btnPridej);

        btnDelete = new JButton("Smaz");
        btnDelete.addActionListener(this);
        panelInputs.add(btnDelete);

        panelMain.add(panelInputs, BorderLayout.NORTH);
        panelMain.add(panelTable, BorderLayout.CENTER);
        panelMain.add(panelFooter, BorderLayout.SOUTH);

        add(panelMain);
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource()== btnPridej){
            System.out.println("Nazev: "+ txtInputName.getText()+ "; Cena za kus: "+txtInputCenaKus.getText()+"; Pocek kusu: "+txtInputPocetKusu.getText());
        }
        if (actionEvent.getSource()== btnDelete){
            
        }
    }
}
