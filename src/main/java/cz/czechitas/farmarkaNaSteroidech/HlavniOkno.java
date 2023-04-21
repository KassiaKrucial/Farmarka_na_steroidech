package cz.czechitas.farmarkaNaSteroidech;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/*
* Ahoj Kači :)
* Logika funguje podle zadání, barvičky jsou moc pěkné :)
* Tak a teď k tomu, co by chtělo vylepšit ;)
* 1) Určitě bych doporučila rozdělit kód do více metod. Takhle to začíná být nepřehledné už u takto malé aplikace.
*    To, že se začal používat nástroj na tvorbu okeních aplikací, nemění nic na tom, jak jako programátorky
*    přistupujeme k Javě. Takže single-responsibility princip nebo cokoliv tomu blízké tak, aby to dávalo smysl :)
*    Metoda, která spravuje event kliknutí, může být klidně jen nějaký rozcestník, který deleguje úkoly na další metody.
* 2) Ty podmínky pro nastavení počtu hus a králíků by chtělo rozdělit na samostatné ify, ne if-else. Takhle se ti vždycky
*    vyhodnotí jen jedna větev, přitom ve skutečnosti jich může nastat víc - například si záporné číslo můžeš zadat všude,
*    správně se ti ale vyhodnotí jen u samců. 
* */

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel labHusy;
    private JLabel labKralici;
    private JLabel labPocetSamcuHus;
    private JTextField txtPocetSamcuHus;
    private JLabel labPocetSamcuKraliku;
    private JTextField txtPocetSamcuKraliku;
    private JLabel labPocetSamicHus;
    private JTextField txtPocetSamicHus;
    private JLabel labPocetSamicKraliku;
    private JTextField txtPocetSamicKraliku;
    private JButton btnVypocitat;
    private JLabel labCelkPocetPredZimou;
    private JLabel labPocetHusPredZimou;
    private JTextField txtPocetHusPredZimou;
    private JLabel labPocetKralikuPredZimou;
    private JTextField txtPocetKralikuPredZimou;
    private JLabel labPotrebnePotraviny;
    private JLabel labHmotnostPsenice;
    private JTextField txtHmotnostPsenice;
    private JLabel labKgPsenice;
    private JLabel labHmotnostMrkve;
    private JTextField txtHmotnostMrkve;
    private JLabel labKgMrkve;
    private JLabel labPocetRadkuPsenice;
    private JTextField txtPocetRadkuPsenice;
    private JLabel labPocetRadkuMrkve;
    private JTextField txtPocetRadkuMrkve;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    public HlavniOkno() {
        initComponents();
    }

    private void btnVypocitatActionPerformed(ActionEvent e) {

        int pocetSamcuHus = Integer.parseInt(txtPocetSamcuHus.getText());
        int pocetSamicHus = Integer.parseInt(txtPocetSamicHus.getText());

        if (pocetSamcuHus < 0) {
            txtPocetSamcuHus.setText(Integer.toString(0));
            txtPocetHusPredZimou.setText
                    (Integer.toString(pocetSamicHus));
        } else if (pocetSamicHus < 0) {
            txtPocetSamicHus.setText(Integer.toString(0));
            txtPocetHusPredZimou.setText
                    (Integer.toString(pocetSamcuHus));
        } else if (pocetSamcuHus > 0 && pocetSamicHus > 0) {
            txtPocetHusPredZimou.setText(Integer.toString
                    (pocetSamicHus * 15 + pocetSamcuHus + pocetSamicHus));
        } else {
            txtPocetHusPredZimou.setText
                    (Integer.toString(pocetSamicHus + pocetSamcuHus));
        }

        int dobaKrmeni = 183;
        double zrniKgPro1HusuNaDen = 0.25;
        double zrniKgPro1HusuNaZimu = zrniKgPro1HusuNaDen * dobaKrmeni;
        double zrniKgZ1Radku = 2;
        int pocetHusCelkem = Integer.parseInt(txtPocetHusPredZimou.getText());

        txtHmotnostPsenice.setText(Double.toString
                (pocetHusCelkem * zrniKgPro1HusuNaZimu));

        double hmotnostPsenice = Double.parseDouble(txtHmotnostPsenice.getText());

        txtPocetRadkuPsenice.setText(Double.toString
                (hmotnostPsenice / zrniKgZ1Radku));

        int pocetSamcuKraliku = Integer.parseInt(txtPocetSamcuKraliku.getText());
        int pocetSamicKraliku = Integer.parseInt(txtPocetSamicKraliku.getText());

        if (pocetSamcuKraliku < 0) {
            txtPocetSamcuKraliku.setText(Integer.toString(0));
            txtPocetKralikuPredZimou.setText
                    (Integer.toString(pocetSamicKraliku));
        } else if (pocetSamicKraliku < 0) {
            txtPocetSamicKraliku.setText(Integer.toString(0));
            txtPocetKralikuPredZimou.setText
                    (Integer.toString(pocetSamcuKraliku));
        } else if (pocetSamcuKraliku > 0 && pocetSamicKraliku > 0) {
            txtPocetKralikuPredZimou.setText(Integer.toString
                    (pocetSamicKraliku * 40 + pocetSamcuKraliku + pocetSamicKraliku));
        } else {
            txtPocetKralikuPredZimou.setText
                    (Integer.toString(pocetSamicKraliku + pocetSamcuKraliku));
        }

        double mrkevKgPro1KralikaNaDen = 0.5;
        double mrkevKgPro1KralikaNaZimu = mrkevKgPro1KralikaNaDen * dobaKrmeni;
        double mrkevKgZ1Radku = 5;
        int pocetKralikuCelkem = Integer.parseInt
                (txtPocetKralikuPredZimou.getText());

        txtHmotnostMrkve.setText(Double.toString
                (pocetKralikuCelkem * mrkevKgPro1KralikaNaZimu));

        double hmotnostMrkve = Double.parseDouble(txtHmotnostMrkve.getText());

        txtPocetRadkuMrkve.setText(Double.toString
                (hmotnostMrkve / mrkevKgZ1Radku));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        labHusy = new JLabel();
        labKralici = new JLabel();
        labPocetSamcuHus = new JLabel();
        txtPocetSamcuHus = new JTextField();
        labPocetSamcuKraliku = new JLabel();
        txtPocetSamcuKraliku = new JTextField();
        labPocetSamicHus = new JLabel();
        txtPocetSamicHus = new JTextField();
        labPocetSamicKraliku = new JLabel();
        txtPocetSamicKraliku = new JTextField();
        btnVypocitat = new JButton();
        labCelkPocetPredZimou = new JLabel();
        labPocetHusPredZimou = new JLabel();
        txtPocetHusPredZimou = new JTextField();
        labPocetKralikuPredZimou = new JLabel();
        txtPocetKralikuPredZimou = new JTextField();
        labPotrebnePotraviny = new JLabel();
        labHmotnostPsenice = new JLabel();
        txtHmotnostPsenice = new JTextField();
        labKgPsenice = new JLabel();
        labHmotnostMrkve = new JLabel();
        txtHmotnostMrkve = new JTextField();
        labKgMrkve = new JLabel();
        labPocetRadkuPsenice = new JLabel();
        txtPocetRadkuPsenice = new JTextField();
        labPocetRadkuMrkve = new JLabel();
        txtPocetRadkuMrkve = new JTextField();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Farm\u00e1\u0159ka na steroidech");
        setFont(new Font("Bahnschrift", Font.BOLD, 22));
        setBackground(new Color(255, 255, 153));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel,hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[fill]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //---- labHusy ----
        labHusy.setText("Husy");
        labHusy.setFont(new Font("Bahnschrift", Font.BOLD, 22));
        labHusy.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labHusy, "cell 0 0 2 1,gapx 10,gapy 10 8");

        //---- labKralici ----
        labKralici.setText("Kr\u00e1l\u00edci");
        labKralici.setFont(new Font("Bahnschrift", Font.BOLD, 22));
        labKralici.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(labKralici, "cell 3 0 2 1,gapx 10,gapy 10 8");

        //---- labPocetSamcuHus ----
        labPocetSamcuHus.setText("Po\u010det samc\u016f:");
        labPocetSamcuHus.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labPocetSamcuHus, "cell 0 1,gapx 10");

        //---- txtPocetSamcuHus ----
        txtPocetSamcuHus.setColumns(15);
        txtPocetSamcuHus.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(txtPocetSamcuHus, "cell 1 1");

        //---- labPocetSamcuKraliku ----
        labPocetSamcuKraliku.setText("Po\u010det samc\u016f:");
        labPocetSamcuKraliku.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labPocetSamcuKraliku, "cell 3 1,gapx 10");

        //---- txtPocetSamcuKraliku ----
        txtPocetSamcuKraliku.setColumns(15);
        txtPocetSamcuKraliku.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(txtPocetSamcuKraliku, "cell 4 1");

        //---- labPocetSamicHus ----
        labPocetSamicHus.setText("Po\u010det samic:");
        labPocetSamicHus.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labPocetSamicHus, "cell 0 2,gapx 10");

        //---- txtPocetSamicHus ----
        txtPocetSamicHus.setColumns(15);
        txtPocetSamicHus.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(txtPocetSamicHus, "cell 1 2");

        //---- labPocetSamicKraliku ----
        labPocetSamicKraliku.setText("Po\u010det samic:");
        labPocetSamicKraliku.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labPocetSamicKraliku, "cell 3 2,gapx 10");

        //---- txtPocetSamicKraliku ----
        txtPocetSamicKraliku.setColumns(15);
        txtPocetSamicKraliku.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(txtPocetSamicKraliku, "cell 4 2");

        //---- btnVypocitat ----
        btnVypocitat.setText("Vypo\u010d\u00edtat");
        btnVypocitat.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        btnVypocitat.addActionListener(e -> btnVypocitatActionPerformed(e));
        contentPane.add(btnVypocitat, "cell 0 3 6 1,alignx center,growx 0,gapy 10 10");

        //---- labCelkPocetPredZimou ----
        labCelkPocetPredZimou.setText("Celkov\u00fd po\u010det po sezon\u011b p\u0159ed zimou");
        labCelkPocetPredZimou.setFont(new Font("Bahnschrift", Font.BOLD, 22));
        contentPane.add(labCelkPocetPredZimou, "cell 0 4 6 1,gapx 10,gapy 10 8");

        //---- labPocetHusPredZimou ----
        labPocetHusPredZimou.setText("Po\u010det hus:");
        labPocetHusPredZimou.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labPocetHusPredZimou, "cell 0 5,gapx 10");

        //---- txtPocetHusPredZimou ----
        txtPocetHusPredZimou.setColumns(15);
        txtPocetHusPredZimou.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        txtPocetHusPredZimou.setEditable(false);
        contentPane.add(txtPocetHusPredZimou, "cell 1 5");

        //---- labPocetKralikuPredZimou ----
        labPocetKralikuPredZimou.setText("Po\u010det kr\u00e1l\u00edk\u016f:");
        labPocetKralikuPredZimou.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labPocetKralikuPredZimou, "cell 3 5,gapx 10");

        //---- txtPocetKralikuPredZimou ----
        txtPocetKralikuPredZimou.setColumns(15);
        txtPocetKralikuPredZimou.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        txtPocetKralikuPredZimou.setEditable(false);
        contentPane.add(txtPocetKralikuPredZimou, "cell 4 5");

        //---- labPotrebnePotraviny ----
        labPotrebnePotraviny.setText("Pot\u0159ebn\u00e9 potraviny");
        labPotrebnePotraviny.setFont(new Font("Bahnschrift", Font.BOLD, 22));
        contentPane.add(labPotrebnePotraviny, "cell 0 6 6 1,gapx 10,gapy 10 8");

        //---- labHmotnostPsenice ----
        labHmotnostPsenice.setText("Hmotnost p\u0161enice:");
        labHmotnostPsenice.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labHmotnostPsenice, "cell 0 7,gapx 10");

        //---- txtHmotnostPsenice ----
        txtHmotnostPsenice.setColumns(15);
        txtHmotnostPsenice.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        txtHmotnostPsenice.setEditable(false);
        contentPane.add(txtHmotnostPsenice, "cell 1 7");

        //---- labKgPsenice ----
        labKgPsenice.setText("kg");
        labKgPsenice.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labKgPsenice, "cell 2 7,gapx null 10");

        //---- labHmotnostMrkve ----
        labHmotnostMrkve.setText("Hmotnost mrkve:");
        labHmotnostMrkve.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labHmotnostMrkve, "cell 3 7,gapx 10");

        //---- txtHmotnostMrkve ----
        txtHmotnostMrkve.setColumns(15);
        txtHmotnostMrkve.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        txtHmotnostMrkve.setEditable(false);
        contentPane.add(txtHmotnostMrkve, "cell 4 7");

        //---- labKgMrkve ----
        labKgMrkve.setText("kg");
        labKgMrkve.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labKgMrkve, "cell 5 7,gapx null 10");

        //---- labPocetRadkuPsenice ----
        labPocetRadkuPsenice.setText("Po\u010det \u0159\u00e1dk\u016f p\u0161enice:");
        labPocetRadkuPsenice.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labPocetRadkuPsenice, "cell 0 8,gapx 10,gapy null 10");

        //---- txtPocetRadkuPsenice ----
        txtPocetRadkuPsenice.setColumns(15);
        txtPocetRadkuPsenice.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        txtPocetRadkuPsenice.setEditable(false);
        contentPane.add(txtPocetRadkuPsenice, "cell 1 8");

        //---- labPocetRadkuMrkve ----
        labPocetRadkuMrkve.setText("Po\u010det \u0159\u00e1dk\u016f mrkve:");
        labPocetRadkuMrkve.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        contentPane.add(labPocetRadkuMrkve, "cell 3 8,gapx 10");

        //---- txtPocetRadkuMrkve ----
        txtPocetRadkuMrkve.setColumns(15);
        txtPocetRadkuMrkve.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        txtPocetRadkuMrkve.setEditable(false);
        contentPane.add(txtPocetRadkuMrkve, "cell 4 8");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
