import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Arayuz extends JFrame {
    private Main mainController;
    private CardLayout mainCardLayout;
    private JPanel mainContentPane;

    private final Color COLOR_PRIMARY = new Color(44, 62, 80);
    private final Color COLOR_PRIMARY_DARK = new Color(26, 37, 48);
    private final Color COLOR_ACCENT = new Color(197, 168, 128);
    private final Color COLOR_ACCENT_HOVER = new Color(212, 185, 150);
    private final Color COLOR_BG = new Color(245, 246, 250);
    private final Color COLOR_WHITE = new Color(255, 255, 255);
    private final Color COLOR_TEXT_DARK = new Color(47, 53, 66);
    private final Color COLOR_TEXT_MUTED = new Color(116, 125, 140);
    private final Color COLOR_SUCCESS = new Color(46, 204, 113);
    private final Color COLOR_DANGER = new Color(231, 76, 60);
    private final Color COLOR_DANGER_HOVER = new Color(192, 57, 43);

    private final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 22);
    private final Font FONT_SUBTITLE = new Font("Segoe UI", Font.PLAIN, 14);
    private final Font FONT_HEADER = new Font("Segoe UI", Font.BOLD, 16);
    private final Font FONT_BODY_BOLD = new Font("Segoe UI", Font.BOLD, 14);
    private final Font FONT_BODY = new Font("Segoe UI", Font.PLAIN, 14);
    private final Font FONT_SMALL = new Font("Segoe UI", Font.PLAIN, 12);

    private JPanel loginCard;
    private JPanel appCard;
    private JPanel contentCardPanel;
    private CardLayout contentCardLayout;

    private SidebarButton btnNavHazir;
    private SidebarButton btnNavOzel;
    private SidebarButton btnNavSiparisler;

    private JTable tblHazirPaketler;
    private DefaultTableModel modelHazirPaketler;
    private JTextField txtHazirMusteriAdi;
    private JTextField txtHazirTelefon;
    private JTextField txtHazirAdres;
    private JTextField txtHazirKisiSayisi;
    private JRadioButton rbPastaYok;
    private JRadioButton rbPastaCikolata;
    private JRadioButton rbPastaMeyve;
    private JRadioButton rbPastaOrman;
    private ButtonGroup bgPastaSecimi;
    private JPanel panelPastaEklentisi;
    private JLabel lblHazirSecilenPaket;
    private JLabel lblHazirBirimFiyat;
    private JLabel lblHazirToplamFiyat;

    private JComboBox<String> cbOzelOrgTuru;
    private JComboBox<Yemek> cbOzelBaslangic;
    private JComboBox<Yemek> cbOzelAnaYemek;
    private JComboBox<Yemek> cbOzelTatli;
    private JTextField txtOzelMusteriAdi;
    private JTextField txtOzelTelefon;
    private JTextField txtOzelAdres;
    private JTextField txtOzelKisiSayisi;
    private JLabel lblOzelBaslangicFiyat;
    private JLabel lblOzelAnaYemekFiyat;
    private JLabel lblOzelTatliFiyat;
    private JLabel lblOzelKisiBasiToplam;
    private JLabel lblOzelToplamFiyat;

    private JTable tblSiparisler;
    private DefaultTableModel modelSiparisler;
    private TableRowSorter<DefaultTableModel> sorterSiparisler;
    private JTextField txtSiparisAra;
    private JLabel lblToplamSiparisSayisi;
    private JLabel lblToplamCiro;

    public Arayuz() {
        this(new Main());
    }

    public Arayuz(Main mainController) {
        this.mainController = mainController;
        setupFrame();
        initComponents();
    }

    private void setupFrame() {
        setTitle("Catering Yönetim Paneli");
        setSize(1100, 750);
        setMinimumSize(new Dimension(950, 650));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainCardLayout = new CardLayout();
        mainContentPane = new JPanel(mainCardLayout);
        setContentPane(mainContentPane);
    }

    private void initComponents() {
        loginCard = createLoginPanel();
        mainContentPane.add(loginCard, "LoginCard");

        appCard = createAppPanel();
        mainContentPane.add(appCard, "AppCard");

        mainCardLayout.show(mainContentPane, "LoginCard");
    }

    private JPanel createLoginPanel() {
        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(COLOR_PRIMARY);

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(COLOR_WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(35, 45, 35, 45)
        ));

        JLabel lblTitle = new JLabel("CATERING YÖNETİM SİSTEMİ");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitle.setForeground(COLOR_PRIMARY);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblSubtitle = new JLabel("Yönetici Giriş Paneli");
        lblSubtitle.setFont(FONT_SUBTITLE);
        lblSubtitle.setForeground(COLOR_TEXT_MUTED);
        lblSubtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblSubtitle.setBorder(BorderFactory.createEmptyBorder(5, 0, 25, 0));

        JLabel lblPass = new JLabel("Şifre:");
        lblPass.setFont(FONT_BODY_BOLD);
        lblPass.setForeground(COLOR_TEXT_DARK);
        lblPass.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPasswordField txtPassword = new JPasswordField(15);
        txtPassword.setFont(FONT_BODY);
        stylePasswordField(txtPassword);
        txtPassword.setMaximumSize(new Dimension(300, 40));
        txtPassword.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblError = new JLabel(" ");
        lblError.setFont(FONT_SMALL);
        lblError.setForeground(COLOR_DANGER);
        lblError.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblError.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));

        ModernButton btnLogin = new ModernButton("Giriş Yap", COLOR_ACCENT, COLOR_PRIMARY);
        btnLogin.setMaximumSize(new Dimension(300, 42));
        btnLogin.setAlignmentX(Component.LEFT_ALIGNMENT);

        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnLogin.doClick();
                }
            }
        });

        btnLogin.addActionListener(e -> {
            String password = new String(txtPassword.getPassword());
            if (password.equals("1234")) {
                lblError.setText(" ");
                txtPassword.setText("");
                mainCardLayout.show(mainContentPane, "AppCard");
                refreshSiparisTable();
            } else {
                lblError.setText("Hatalı şifre! Lütfen tekrar deneyin.");
                txtPassword.requestFocus();
                txtPassword.selectAll();
            }
        });

        card.add(lblTitle);
        card.add(lblSubtitle);
        card.add(lblPass);
        card.add(Box.createRigidArea(new Dimension(0, 8)));
        card.add(txtPassword);
        card.add(lblError);
        card.add(btnLogin);

        container.add(card);
        return container;
    }

    private JPanel createAppPanel() {
        JPanel appPanel = new JPanel(new BorderLayout());

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(COLOR_PRIMARY);
        sidebar.setPreferredSize(new Dimension(240, 0));

        JPanel logoPanel = new JPanel(new BorderLayout());
        logoPanel.setBackground(COLOR_PRIMARY_DARK);
        logoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        logoPanel.setMaximumSize(new Dimension(240, 80));

        JLabel logoText = new JLabel("Catering Yönetim");
        logoText.setFont(FONT_HEADER);
        logoText.setForeground(COLOR_WHITE);
        logoPanel.add(logoText, BorderLayout.CENTER);

        btnNavHazir = new SidebarButton("Hazır Paket Siparişi");
        btnNavOzel = new SidebarButton("Özel Menü Siparişi");
        btnNavSiparisler = new SidebarButton("Alınan Siparişler");

        btnNavHazir.setActive(true);

        btnNavHazir.addActionListener(e -> switchContentCard("HazirPanel", btnNavHazir));
        btnNavOzel.addActionListener(e -> switchContentCard("OzelPanel", btnNavOzel));
        btnNavSiparisler.addActionListener(e -> switchContentCard("SiparislerPanel", btnNavSiparisler));

        SidebarButton btnLogout = new SidebarButton("Oturumu Kapat");
        btnLogout.setBackground(new Color(192, 57, 43));
        btnLogout.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Güvenli çıkış yapmak istiyor musunuz?",
                    "Oturumu Kapat",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (result == JOptionPane.YES_OPTION) {
                mainCardLayout.show(mainContentPane, "LoginCard");
            }
        });

        sidebar.add(logoPanel);
        sidebar.add(Box.createRigidArea(new Dimension(0, 15)));
        sidebar.add(btnNavHazir);
        sidebar.add(btnNavOzel);
        sidebar.add(btnNavSiparisler);
        sidebar.add(Box.createVerticalGlue());
        sidebar.add(btnLogout);

        contentCardLayout = new CardLayout();
        contentCardPanel = new JPanel(contentCardLayout);
        contentCardPanel.setBackground(COLOR_BG);

        contentCardPanel.add(createHazirPaketPanel(), "HazirPanel");
        contentCardPanel.add(createOzelMenuPanel(), "OzelPanel");
        contentCardPanel.add(createSiparislerPanel(), "SiparislerPanel");

        appPanel.add(sidebar, BorderLayout.WEST);
        appPanel.add(contentCardPanel, BorderLayout.CENTER);

        return appPanel;
    }

    private void switchContentCard(String cardName, SidebarButton activeButton) {
        btnNavHazir.setActive(false);
        btnNavOzel.setActive(false);
        btnNavSiparisler.setActive(false);
        activeButton.setActive(true);
        contentCardLayout.show(contentCardPanel, cardName);
        if (cardName.equals("SiparislerPanel")) {
            refreshSiparisTable();
        }
    }

    private JPanel createHazirPaketPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_BG);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        JLabel title = new JLabel("Hazır Paket Menüleri ve Sipariş");
        title.setFont(FONT_TITLE);
        title.setForeground(COLOR_PRIMARY);
        headerPanel.add(title, BorderLayout.WEST);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel contentGrid = new JPanel(new GridLayout(1, 2, 20, 0));
        contentGrid.setBackground(COLOR_BG);

        JPanel leftCard = createCardPanel();
        leftCard.setLayout(new BorderLayout(0, 15));

        JLabel lblSecimBasligi = new JLabel("1. Paket Seçimi Yapınız");
        lblSecimBasligi.setFont(FONT_HEADER);
        lblSecimBasligi.setForeground(COLOR_PRIMARY);
        leftCard.add(lblSecimBasligi, BorderLayout.NORTH);

        String[] columns = {"Paket Adı", "Kişi Başı Ücret", "Sabit İçerik"};
        modelHazirPaketler = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        tblHazirPaketler = new JTable(modelHazirPaketler);
        styleTable(tblHazirPaketler);
        JScrollPane scrollTable = new JScrollPane(tblHazirPaketler);
        scrollTable.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        leftCard.add(scrollTable, BorderLayout.CENTER);

        for (YemekMenusu menu : mainController.getHazirMenuListesi()) {
            modelHazirPaketler.addRow(new Object[]{
                    menu.getMenuAdi(),
                    menu.getKisiUcreti() + " TL",
                    menu.getYemekİcerigi().toString()
            });
        }

        panelPastaEklentisi = new JPanel();
        panelPastaEklentisi.setLayout(new BoxLayout(panelPastaEklentisi, BoxLayout.Y_AXIS));
        panelPastaEklentisi.setBackground(COLOR_WHITE);
        panelPastaEklentisi.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(COLOR_ACCENT, 1),
                "Düğün Paketi Pasta Tercihi (Kişi Başı Fiyata Etki Eder)",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                FONT_BODY_BOLD,
                COLOR_PRIMARY
        ));

        bgPastaSecimi = new ButtonGroup();
        rbPastaYok = new JRadioButton("Pasta İstemiyorum (-50 TL Düşer)");
        rbPastaCikolata = new JRadioButton("Çikolatalı Pasta (Fiyata Dahil)");
        rbPastaMeyve = new JRadioButton("Meyveli Pasta (Fiyata Dahil)");
        rbPastaOrman = new JRadioButton("Orman Meyveli Pasta (Fiyata Dahil)");

        rbPastaCikolata.setSelected(true);

        bgPastaSecimi.add(rbPastaYok);
        bgPastaSecimi.add(rbPastaCikolata);
        bgPastaSecimi.add(rbPastaMeyve);
        bgPastaSecimi.add(rbPastaOrman);

        styleRadioButton(rbPastaYok);
        styleRadioButton(rbPastaCikolata);
        styleRadioButton(rbPastaMeyve);
        styleRadioButton(rbPastaOrman);

        panelPastaEklentisi.add(rbPastaYok);
        panelPastaEklentisi.add(rbPastaCikolata);
        panelPastaEklentisi.add(rbPastaMeyve);
        panelPastaEklentisi.add(rbPastaOrman);
        panelPastaEklentisi.setVisible(false);

        leftCard.add(panelPastaEklentisi, BorderLayout.SOUTH);

        JPanel rightCard = createCardPanel();
        rightCard.setLayout(new BorderLayout(0, 15));

        JLabel lblFormBasligi = new JLabel("2. Müşteri Bilgileri ve Sipariş Tamamlama");
        lblFormBasligi.setFont(FONT_HEADER);
        lblFormBasligi.setForeground(COLOR_PRIMARY);
        rightCard.add(lblFormBasligi, BorderLayout.NORTH);

        JPanel formFields = new JPanel(new GridBagLayout());
        formFields.setBackground(COLOR_WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(5, 5, 10, 5);

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        JLabel lblName = new JLabel("Müşteri Adı:");
        lblName.setFont(FONT_BODY_BOLD);
        formFields.add(lblName, gbc);

        gbc.gridx = 1; gbc.weightx = 0.7;
        txtHazirMusteriAdi = new JTextField();
        styleTextField(txtHazirMusteriAdi);
        formFields.add(txtHazirMusteriAdi, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        JLabel lblTel = new JLabel("Telefon (11 Hane):");
        lblTel.setFont(FONT_BODY_BOLD);
        formFields.add(lblTel, gbc);

        gbc.gridx = 1; gbc.weightx = 0.7;
        txtHazirTelefon = new JTextField();
        styleTextField(txtHazirTelefon);
        formFields.add(txtHazirTelefon, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        JLabel lblAdres = new JLabel("Teslimat Adresi:");
        lblAdres.setFont(FONT_BODY_BOLD);
        formFields.add(lblAdres, gbc);

        gbc.gridx = 1; gbc.weightx = 0.7;
        txtHazirAdres = new JTextField();
        styleTextField(txtHazirAdres);
        formFields.add(txtHazirAdres, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.3;
        JLabel lblKisi = new JLabel("Davetli (Min 20):");
        lblKisi.setFont(FONT_BODY_BOLD);
        formFields.add(lblKisi, gbc);

        gbc.gridx = 1; gbc.weightx = 0.7;
        txtHazirKisiSayisi = new JTextField();
        styleTextField(txtHazirKisiSayisi);
        formFields.add(txtHazirKisiSayisi, gbc);

        JPanel summaryPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        summaryPanel.setBackground(new Color(248, 249, 250));
        summaryPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        summaryPanel.add(new JLabel("Seçilen Menü:") {{ setFont(FONT_BODY_BOLD); }});
        lblHazirSecilenPaket = new JLabel("Seçim Yapılmadı") {{ setFont(FONT_BODY); }};
        summaryPanel.add(lblHazirSecilenPaket);

        summaryPanel.add(new JLabel("Kişi Başı Ücret:") {{ setFont(FONT_BODY_BOLD); }});
        lblHazirBirimFiyat = new JLabel("0 TL") {{ setFont(FONT_BODY); }};
        summaryPanel.add(lblHazirBirimFiyat);

        summaryPanel.add(new JLabel("Toplam Tutar:") {{ setFont(FONT_BODY_BOLD); }});
        lblHazirToplamFiyat = new JLabel("0 TL") {{ setFont(new Font("Segoe UI", Font.BOLD, 16)); setForeground(COLOR_PRIMARY); }};
        summaryPanel.add(lblHazirToplamFiyat);

        JPanel formContainer = new JPanel(new BorderLayout(0, 15));
        formContainer.setBackground(COLOR_WHITE);
        formContainer.add(formFields, BorderLayout.NORTH);
        formContainer.add(summaryPanel, BorderLayout.CENTER);

        ModernButton btnSiparisOlustur = new ModernButton("Siparişi Kaydet ve Tamamla", COLOR_ACCENT, COLOR_PRIMARY);
        formContainer.add(btnSiparisOlustur, BorderLayout.SOUTH);

        rightCard.add(formContainer, BorderLayout.CENTER);

        contentGrid.add(leftCard);
        contentGrid.add(rightCard);
        mainPanel.add(contentGrid, BorderLayout.CENTER);

        tblHazirPaketler.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tblHazirPaketler.getSelectedRow();
                if (row != -1) {
                    String menuAdi = (String) tblHazirPaketler.getValueAt(row, 0);
                    lblHazirSecilenPaket.setText(menuAdi);

                    if (menuAdi.trim().startsWith("Düğün")) {
                        panelPastaEklentisi.setVisible(true);
                    } else {
                        panelPastaEklentisi.setVisible(false);
                    }
                    leftCard.revalidate();
                    leftCard.repaint();

                    updateHazirPaketSummary();
                }
            }
        });

        ActionListener pastaChangeListener = e -> updateHazirPaketSummary();
        rbPastaYok.addActionListener(pastaChangeListener);
        rbPastaCikolata.addActionListener(pastaChangeListener);
        rbPastaMeyve.addActionListener(pastaChangeListener);
        rbPastaOrman.addActionListener(pastaChangeListener);

        txtHazirKisiSayisi.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { updateHazirPaketSummary(); }
            public void removeUpdate(DocumentEvent e) { updateHazirPaketSummary(); }
            public void insertUpdate(DocumentEvent e) { updateHazirPaketSummary(); }
        });

        btnSiparisOlustur.addActionListener(e -> {
            int selectedRow = tblHazirPaketler.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Lütfen öncelikle sol tablodan bir hazır menü seçiniz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }

            YemekMenusu secilenPaket = mainController.getHazirMenuListesi().get(selectedRow);

            String musteriAdi = txtHazirMusteriAdi.getText().trim();
            String telefon = txtHazirTelefon.getText().trim();
            String adres = txtHazirAdres.getText().trim();
            String kisiSayisiStr = txtHazirKisiSayisi.getText().trim();

            if (musteriAdi.isEmpty() || telefon.isEmpty() || adres.isEmpty() || kisiSayisiStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurunuz!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!musteriAdi.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "Müşteri adında sadece harf bulunabilir! Lütfen kontrol edin.", "Geçersiz Ad", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isUnique = true;
            for (Siparis s : mainController.getSiparisListesi()) {
                if (s.getMusteriAdi().equalsIgnoreCase(musteriAdi)) {
                    isUnique = false;
                    break;
                }
            }
            if (!isUnique) {
                JOptionPane.showMessageDialog(this, "Bu müşteri adına ait zaten aktif bir sipariş bulunmaktadır! Lütfen farklı bir isim giriniz.", "Kayıt Mevcut", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (telefon.length() != 11 || !telefon.matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(this, "Telefon numarası tam olarak 11 haneli ve sadece rakamlardan oluşmalıdır!", "Geçersiz Telefon", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int kisiSayisi;
            try {
                kisiSayisi = Integer.parseInt(kisiSayisiStr);
                if (kisiSayisi < 20) {
                    JOptionPane.showMessageDialog(this, "Catering hizmetimiz hazır paketler için en az 20 kişiliktir!", "Geçersiz Davetli Sayısı", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Davetli sayısı alanı geçerli bir tam sayı olmalıdır!", "Geçersiz Sayı", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double finalBirimFiyat = secilenPaket.getKisiUcreti();
            String detaylar = secilenPaket.getYemekİcerigi().toString();

            if (secilenPaket.getMenuAdi().trim().startsWith("Düğün")) {
                if (rbPastaYok.isSelected()) {
                    finalBirimFiyat -= 50.0;
                    detaylar += " (Pasta: İstenmedi)";
                } else {
                    String secilenPasta = "Çikolatalı Pasta";
                    if (rbPastaMeyve.isSelected()) secilenPasta = "Meyveli Pasta";
                    else if (rbPastaOrman.isSelected()) secilenPasta = "Orman Meyveli Pasta";
                    detaylar += " (Pasta: " + secilenPasta + ")";
                }
            }

            Siparis yeniSiparis = new Siparis(musteriAdi, telefon, adres, secilenPaket.getMenuAdi(), detaylar, finalBirimFiyat, kisiSayisi);
            mainController.getSiparisListesi().add(yeniSiparis);

            txtHazirMusteriAdi.setText("");
            txtHazirTelefon.setText("");
            txtHazirAdres.setText("");
            txtHazirKisiSayisi.setText("");
            tblHazirPaketler.clearSelection();
            panelPastaEklentisi.setVisible(false);
            lblHazirSecilenPaket.setText("Seçim Yapılmadı");
            lblHazirBirimFiyat.setText("0 TL");
            lblHazirToplamFiyat.setText("0 TL");

            JOptionPane.showMessageDialog(this, "Siparişiniz başarıyla alınmıştır!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
        });

        return mainPanel;
    }

    private void updateHazirPaketSummary() {
        int row = tblHazirPaketler.getSelectedRow();
        if (row == -1) {
            lblHazirBirimFiyat.setText("0 TL");
            lblHazirToplamFiyat.setText("0 TL");
            return;
        }

        YemekMenusu secilenPaket = mainController.getHazirMenuListesi().get(row);
        double birimFiyat = secilenPaket.getKisiUcreti();

        if (secilenPaket.getMenuAdi().trim().startsWith("Düğün")) {
            if (rbPastaYok.isSelected()) {
                birimFiyat -= 50.0;
            }
        }

        lblHazirBirimFiyat.setText(birimFiyat + " TL");

        String kisiStr = txtHazirKisiSayisi.getText().trim();
        if (!kisiStr.isEmpty()) {
            try {
                int kisi = Integer.parseInt(kisiStr);
                if (kisi > 0) {
                    lblHazirToplamFiyat.setText((birimFiyat * kisi) + " TL");
                } else {
                    lblHazirToplamFiyat.setText("0 TL");
                }
            } catch (NumberFormatException e) {
                lblHazirToplamFiyat.setText("- TL (Geçersiz)");
            }
        } else {
            lblHazirToplamFiyat.setText("0 TL");
        }
    }

    private JPanel createOzelMenuPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_BG);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
        JLabel title = new JLabel("Özel Menü Organizasyon Siparişi");
        title.setFont(FONT_TITLE);
        title.setForeground(COLOR_PRIMARY);
        headerPanel.add(title, BorderLayout.WEST);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel contentGrid = new JPanel(new GridLayout(1, 2, 20, 0));
        contentGrid.setBackground(COLOR_BG);

        JPanel leftCard = createCardPanel();
        leftCard.setLayout(new BorderLayout(0, 15));

        JLabel lblSecimBasligi = new JLabel("1. Menü Kombinasyonunu Oluşturun");
        lblSecimBasligi.setFont(FONT_HEADER);
        lblSecimBasligi.setForeground(COLOR_PRIMARY);
        leftCard.add(lblSecimBasligi, BorderLayout.NORTH);

        JPanel comboPanel = new JPanel(new GridBagLayout());
        comboPanel.setBackground(COLOR_WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 5, 10, 5);

        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        JLabel lblOrg = new JLabel("Organizasyon:");
        lblOrg.setFont(FONT_BODY_BOLD);
        comboPanel.add(lblOrg, gbc);

        gbc.gridx = 1; gbc.weightx = 0.7;
        cbOzelOrgTuru = new JComboBox<>(new String[]{
                "Düğün Organizasyonu",
                "Sünnet Organizasyonu",
                "Nişan / Kına Organizasyonu",
                "Doğum Günü Organizasyonu"
        });
        styleComboBox(cbOzelOrgTuru);
        comboPanel.add(cbOzelOrgTuru, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        JLabel lblBaslangic = new JLabel("Ara Sıcak / Aperatif:");
        lblBaslangic.setFont(FONT_BODY_BOLD);
        comboPanel.add(lblBaslangic, gbc);

        gbc.gridx = 1; gbc.weightx = 0.7;
        cbOzelBaslangic = new JComboBox<>();
        styleComboBox(cbOzelBaslangic);
        cbOzelBaslangic.setRenderer(new YemekComboBoxRenderer());
        comboPanel.add(cbOzelBaslangic, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        JLabel lblAnaYemek = new JLabel("Ana Yemek:");
        lblAnaYemek.setFont(FONT_BODY_BOLD);
        comboPanel.add(lblAnaYemek, gbc);

        gbc.gridx = 1; gbc.weightx = 0.7;
        cbOzelAnaYemek = new JComboBox<>();
        styleComboBox(cbOzelAnaYemek);
        cbOzelAnaYemek.setRenderer(new YemekComboBoxRenderer());
        comboPanel.add(cbOzelAnaYemek, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 0.3;
        JLabel lblTatli = new JLabel("Tatlı:");
        lblTatli.setFont(FONT_BODY_BOLD);
        comboPanel.add(lblTatli, gbc);

        gbc.gridx = 1; gbc.weightx = 0.7;
        cbOzelTatli = new JComboBox<>();
        styleComboBox(cbOzelTatli);
        cbOzelTatli.setRenderer(new YemekComboBoxRenderer());
        comboPanel.add(cbOzelTatli, gbc);

        JPanel priceBreakdown = new JPanel(new GridLayout(4, 2, 5, 5));
        priceBreakdown.setBackground(COLOR_WHITE);
        priceBreakdown.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1), "Yemek Fiyat Dökümü", TitledBorder.LEFT, TitledBorder.TOP, FONT_SMALL, COLOR_PRIMARY),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

        priceBreakdown.add(new JLabel("Aperatif / Ara Sıcak:") {{ setFont(FONT_BODY); }});
        lblOzelBaslangicFiyat = new JLabel("0.0 TL") {{ setFont(FONT_BODY_BOLD); }};
        priceBreakdown.add(lblOzelBaslangicFiyat);

        priceBreakdown.add(new JLabel("Ana Yemek:") {{ setFont(FONT_BODY); }});
        lblOzelAnaYemekFiyat = new JLabel("0.0 TL") {{ setFont(FONT_BODY_BOLD); }};
        priceBreakdown.add(lblOzelAnaYemekFiyat);

        priceBreakdown.add(new JLabel("Tatlı:") {{ setFont(FONT_BODY); }});
        lblOzelTatliFiyat = new JLabel("0.0 TL") {{ setFont(FONT_BODY_BOLD); }};
        priceBreakdown.add(lblOzelTatliFiyat);

        priceBreakdown.add(new JLabel("Kişi Başı Toplam:") {{ setFont(FONT_BODY_BOLD); setForeground(COLOR_PRIMARY); }});
        lblOzelKisiBasiToplam = new JLabel("0.0 TL") {{ setFont(new Font("Segoe UI", Font.BOLD, 15)); setForeground(COLOR_PRIMARY); }};
        priceBreakdown.add(lblOzelKisiBasiToplam);

        JPanel leftContainer = new JPanel(new BorderLayout(0, 15));
        leftContainer.setBackground(COLOR_WHITE);
        leftContainer.add(comboPanel, BorderLayout.NORTH);
        leftContainer.add(priceBreakdown, BorderLayout.CENTER);

        leftCard.add(leftContainer, BorderLayout.CENTER);

        JPanel rightCard = createCardPanel();
        rightCard.setLayout(new BorderLayout(0, 15));

        JLabel lblFormBasligi = new JLabel("2. Müşteri Bilgileri ve Sipariş Tamamlama");
        lblFormBasligi.setFont(FONT_HEADER);
        lblFormBasligi.setForeground(COLOR_PRIMARY);
        rightCard.add(lblFormBasligi, BorderLayout.NORTH);

        JPanel formFields = new JPanel(new GridBagLayout());
        formFields.setBackground(COLOR_WHITE);
        GridBagConstraints gbcForm = new GridBagConstraints();
        gbcForm.fill = GridBagConstraints.HORIZONTAL;
        gbcForm.insets = new java.awt.Insets(5, 5, 10, 5);

        gbcForm.gridx = 0; gbcForm.gridy = 0; gbcForm.weightx = 0.3;
        JLabel lblName = new JLabel("Müşteri Adı:");
        lblName.setFont(FONT_BODY_BOLD);
        formFields.add(lblName, gbcForm);

        gbcForm.gridx = 1; gbcForm.weightx = 0.7;
        txtOzelMusteriAdi = new JTextField();
        styleTextField(txtOzelMusteriAdi);
        formFields.add(txtOzelMusteriAdi, gbcForm);

        gbcForm.gridx = 0; gbcForm.gridy = 1; gbcForm.weightx = 0.3;
        JLabel lblTel = new JLabel("Telefon (11 Hane):");
        lblTel.setFont(FONT_BODY_BOLD);
        formFields.add(lblTel, gbcForm);

        gbcForm.gridx = 1; gbcForm.weightx = 0.7;
        txtOzelTelefon = new JTextField();
        styleTextField(txtOzelTelefon);
        formFields.add(txtOzelTelefon, gbcForm);

        gbcForm.gridx = 0; gbcForm.gridy = 2; gbcForm.weightx = 0.3;
        JLabel lblAdres = new JLabel("Teslimat Adresi:");
        lblAdres.setFont(FONT_BODY_BOLD);
        formFields.add(lblAdres, gbcForm);

        gbcForm.gridx = 1; gbcForm.weightx = 0.7;
        txtOzelAdres = new JTextField();
        styleTextField(txtOzelAdres);
        formFields.add(txtOzelAdres, gbcForm);

        gbcForm.gridx = 0; gbcForm.gridy = 3; gbcForm.weightx = 0.3;
        JLabel lblKisi = new JLabel("Davetli (Min 10):");
        lblKisi.setFont(FONT_BODY_BOLD);
        formFields.add(lblKisi, gbcForm);

        gbcForm.gridx = 1; gbcForm.weightx = 0.7;
        txtOzelKisiSayisi = new JTextField();
        styleTextField(txtOzelKisiSayisi);
        formFields.add(txtOzelKisiSayisi, gbcForm);

        JPanel summaryPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        summaryPanel.setBackground(new Color(248, 249, 250));
        summaryPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        summaryPanel.add(new JLabel("Davetli Sayısı:") {{ setFont(FONT_BODY_BOLD); }});
        summaryPanel.add(new JLabel() {
            {
                setFont(FONT_BODY);
                txtOzelKisiSayisi.getDocument().addDocumentListener(new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) { updateText(); }
                    public void removeUpdate(DocumentEvent e) { updateText(); }
                    public void insertUpdate(DocumentEvent e) { updateText(); }
                    private void updateText() { setText(txtOzelKisiSayisi.getText()); }
                });
            }
        });

        summaryPanel.add(new JLabel("Toplam Tutar:") {{ setFont(FONT_BODY_BOLD); }});
        lblOzelToplamFiyat = new JLabel("0 TL") {{ setFont(new Font("Segoe UI", Font.BOLD, 16)); setForeground(COLOR_PRIMARY); }};
        summaryPanel.add(lblOzelToplamFiyat);

        JPanel rightContainer = new JPanel(new BorderLayout(0, 15));
        rightContainer.setBackground(COLOR_WHITE);
        rightContainer.add(formFields, BorderLayout.NORTH);
        rightContainer.add(summaryPanel, BorderLayout.CENTER);

        ModernButton btnOzelSiparisOlustur = new ModernButton("Özel Organizasyon Siparişini Kaydet", COLOR_ACCENT, COLOR_PRIMARY);
        rightContainer.add(btnOzelSiparisOlustur, BorderLayout.SOUTH);

        rightCard.add(rightContainer, BorderLayout.CENTER);

        contentGrid.add(leftCard);
        contentGrid.add(rightCard);
        mainPanel.add(contentGrid, BorderLayout.CENTER);

        populateOzelYemekDropdowns(0);

        cbOzelOrgTuru.addActionListener(e -> {
            int selectedIndex = cbOzelOrgTuru.getSelectedIndex();
            populateOzelYemekDropdowns(selectedIndex);
            updateOzelSiparisSummary();
        });

        ActionListener dropdownListener = e -> {
            Yemek b = (Yemek) cbOzelBaslangic.getSelectedItem();
            Yemek a = (Yemek) cbOzelAnaYemek.getSelectedItem();
            Yemek t = (Yemek) cbOzelTatli.getSelectedItem();

            if (b != null) lblOzelBaslangicFiyat.setText(b.getFiyat() + " TL");
            if (a != null) lblOzelAnaYemekFiyat.setText(a.getFiyat() + " TL");
            if (t != null) lblOzelTatliFiyat.setText(t.getFiyat() + " TL");

            updateOzelSiparisSummary();
        };

        cbOzelBaslangic.addActionListener(dropdownListener);
        cbOzelAnaYemek.addActionListener(dropdownListener);
        cbOzelTatli.addActionListener(dropdownListener);

        txtOzelKisiSayisi.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { updateOzelSiparisSummary(); }
            public void removeUpdate(DocumentEvent e) { updateOzelSiparisSummary(); }
            public void insertUpdate(DocumentEvent e) { updateOzelSiparisSummary(); }
        });

        btnOzelSiparisOlustur.addActionListener(e -> {
            String musteriAdi = txtOzelMusteriAdi.getText().trim();
            String telefon = txtOzelTelefon.getText().trim();
            String adres = txtOzelAdres.getText().trim();
            String kisiSayisiStr = txtOzelKisiSayisi.getText().trim();

            Yemek b = (Yemek) cbOzelBaslangic.getSelectedItem();
            Yemek a = (Yemek) cbOzelAnaYemek.getSelectedItem();
            Yemek t = (Yemek) cbOzelTatli.getSelectedItem();

            if (b == null || a == null || t == null) {
                JOptionPane.showMessageDialog(this, "Menü seçimi eksik! Lütfen her yemek kategorisi için seçim yapınız.", "Eksik Menü Seçimi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (musteriAdi.isEmpty() || telefon.isEmpty() || adres.isEmpty() || kisiSayisiStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurunuz!", "Eksik Bilgi", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!musteriAdi.matches("^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$")) {
                JOptionPane.showMessageDialog(this, "Müşteri adında sadece harf bulunabilir!", "Geçersiz Ad", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean isUnique = true;
            for (Siparis s : mainController.getSiparisListesi()) {
                if (s.getMusteriAdi().equalsIgnoreCase(musteriAdi)) {
                    isUnique = false;
                    break;
                }
            }
            if (!isUnique) {
                JOptionPane.showMessageDialog(this, "Bu müşteri adına ait zaten aktif bir sipariş bulunmaktadır! Lütfen farklı bir isim giriniz.", "Kayıt Mevcut", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (telefon.length() != 11 || !telefon.matches("^[0-9]+$")) {
                JOptionPane.showMessageDialog(this, "Telefon numarası tam olarak 11 haneli ve sadece rakamlardan oluşmalıdır!", "Geçersiz Telefon", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int kisiSayisi;
            try {
                kisiSayisi = Integer.parseInt(kisiSayisiStr);
                if (kisiSayisi < 10) {
                    JOptionPane.showMessageDialog(this, "Özel Catering hizmetimiz en az 10 kişiliktir!", "Geçersiz Davetli Sayısı", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Davetli sayısı alanı geçerli bir tam sayı olmalıdır!", "Geçersiz Sayı", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String orgTuruText = (String) cbOzelOrgTuru.getSelectedItem();
            String detaylar = b.getAd() + " + " + a.getAd() + " + " + t.getAd();
            double kisiBasiUcret = b.getFiyat() + a.getFiyat() + t.getFiyat();

            Siparis ozelSiparis = new Siparis(musteriAdi, telefon, adres, orgTuruText, detaylar, kisiBasiUcret, kisiSayisi);
            mainController.getSiparisListesi().add(ozelSiparis);

            txtOzelMusteriAdi.setText("");
            txtOzelTelefon.setText("");
            txtOzelAdres.setText("");
            txtOzelKisiSayisi.setText("");
            cbOzelOrgTuru.setSelectedIndex(0);

            JOptionPane.showMessageDialog(this, "Özel menü organizasyon siparişiniz başarıyla kaydedilmiştir!", "Sipariş Alındı", JOptionPane.INFORMATION_MESSAGE);
        });

        return mainPanel;
    }

    private void populateOzelYemekDropdowns(int orgIndex) {
        cbOzelBaslangic.removeAllItems();
        cbOzelAnaYemek.removeAllItems();
        cbOzelTatli.removeAllItems();

        List<Yemek> baslangiclar;
        List<Yemek> anaYemekler;
        List<Yemek> tatlilar;

        switch (orgIndex) {
            case 0:
                baslangiclar = mainController.getDugunAraSicaklar();
                anaYemekler = mainController.getDugunAnaYemekler();
                tatlilar = mainController.getDugunTatlilar();
                break;
            case 1:
                baslangiclar = mainController.getSunnetAperatifler();
                anaYemekler = mainController.getSunnetAnaYemekler();
                tatlilar = mainController.getSunnetTatlilar();
                break;
            case 2:
                baslangiclar = mainController.getNisanAraSicaklar();
                anaYemekler = mainController.getNisanAnaYemekler();
                tatlilar = mainController.getNisanTatlilar();
                break;
            case 3:
            default:
                baslangiclar = mainController.getDogumGunuAperatifler();
                anaYemekler = mainController.getDogumGunuAnaYemekler();
                tatlilar = mainController.getDogumGunuTatlilar();
                break;
        }

        for (Yemek y : baslangiclar) cbOzelBaslangic.addItem(y);
        for (Yemek y : anaYemekler) cbOzelAnaYemek.addItem(y);
        for (Yemek y : tatlilar) cbOzelTatli.addItem(y);
    }

    private void updateOzelSiparisSummary() {
        Yemek b = (Yemek) cbOzelBaslangic.getSelectedItem();
        Yemek a = (Yemek) cbOzelAnaYemek.getSelectedItem();
        Yemek t = (Yemek) cbOzelTatli.getSelectedItem();

        if (b == null || a == null || t == null) {
            lblOzelKisiBasiToplam.setText("0.0 TL");
            lblOzelToplamFiyat.setText("0 TL");
            return;
        }

        double kisiBasi = b.getFiyat() + a.getFiyat() + t.getFiyat();
        lblOzelKisiBasiToplam.setText(kisiBasi + " TL");

        String kisiStr = txtOzelKisiSayisi.getText().trim();
        if (!kisiStr.isEmpty()) {
            try {
                int kisi = Integer.parseInt(kisiStr);
                if (kisi > 0) {
                    lblOzelToplamFiyat.setText((kisiBasi * kisi) + " TL");
                } else {
                    lblOzelToplamFiyat.setText("0 TL");
                }
            } catch (NumberFormatException e) {
                lblOzelToplamFiyat.setText("- TL (Geçersiz)");
            }
        } else {
            lblOzelToplamFiyat.setText("0 TL");
        }
    }

    private JPanel createSiparislerPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(COLOR_BG);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_BG);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JLabel title = new JLabel("Alınan Tüm Siparişler");
        title.setFont(FONT_TITLE);
        title.setForeground(COLOR_PRIMARY);
        headerPanel.add(title, BorderLayout.WEST);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel centerCard = createCardPanel();
        centerCard.setLayout(new BorderLayout(0, 15));

        JPanel topActionPanel = new JPanel(new BorderLayout(15, 0));
        topActionPanel.setBackground(COLOR_WHITE);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        searchPanel.setBackground(COLOR_WHITE);
        searchPanel.add(new JLabel("Müşteri Ara: ") {{ setFont(FONT_BODY_BOLD); setForeground(COLOR_PRIMARY); }});
        txtSiparisAra = new JTextField(18);
        styleTextField(txtSiparisAra);
        searchPanel.add(txtSiparisAra);
        topActionPanel.add(searchPanel, BorderLayout.WEST);

        centerCard.add(topActionPanel, BorderLayout.NORTH);

        String[] columns = {"Müşteri Adı", "Telefon", "Adres", "Sipariş Türü", "İçerik Detayı", "Kişi Sayısı", "Kişi Başı Ücret", "Toplam Tutar"};
        modelSiparisler = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };
        tblSiparisler = new JTable(modelSiparisler);
        styleTable(tblSiparisler);

        sorterSiparisler = new TableRowSorter<>(modelSiparisler);
        tblSiparisler.setRowSorter(sorterSiparisler);

        JScrollPane scrollTable = new JScrollPane(tblSiparisler);
        scrollTable.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        centerCard.add(scrollTable, BorderLayout.CENTER);

        JPanel bottomActionPanel = new JPanel(new BorderLayout());
        bottomActionPanel.setBackground(COLOR_WHITE);

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        statsPanel.setBackground(COLOR_WHITE);
        lblToplamSiparisSayisi = new JLabel("Toplam Sipariş: 0");
        lblToplamSiparisSayisi.setFont(FONT_BODY_BOLD);
        lblToplamSiparisSayisi.setForeground(COLOR_PRIMARY);

        lblToplamCiro = new JLabel("Toplam Ciro: 0 TL");
        lblToplamCiro.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblToplamCiro.setForeground(new Color(39, 174, 96));

        statsPanel.add(lblToplamSiparisSayisi);
        statsPanel.add(new JLabel("|") {{ setForeground(COLOR_TEXT_MUTED); }});
        statsPanel.add(lblToplamCiro);
        bottomActionPanel.add(statsPanel, BorderLayout.WEST);

        ModernButton btnSiparisIptal = new ModernButton("Seçili Siparişi İptal Et / Sil", COLOR_DANGER, COLOR_WHITE);
        btnSiparisIptal.setHoverBg(COLOR_DANGER_HOVER);
        bottomActionPanel.add(btnSiparisIptal, BorderLayout.EAST);

        centerCard.add(bottomActionPanel, BorderLayout.SOUTH);

        mainPanel.add(centerCard, BorderLayout.CENTER);

        txtSiparisAra.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { filterTable(); }
            public void removeUpdate(DocumentEvent e) { filterTable(); }
            public void insertUpdate(DocumentEvent e) { filterTable(); }
        });

        btnSiparisIptal.addActionListener(e -> {
            int viewRow = tblSiparisler.getSelectedRow();
            if (viewRow == -1) {
                JOptionPane.showMessageDialog(this, "Lütfen silmek istediğiniz siparişin satırını seçiniz!", "Seçim Yok", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int modelRow = tblSiparisler.convertRowIndexToModel(viewRow);
            String musteriAdi = (String) modelSiparisler.getValueAt(modelRow, 0);

            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "'" + musteriAdi + "' adına kayıtlı siparişi iptal etmek ve kalıcı olarak silmek istediğinize emin misiniz?",
                    "Sipariş İptal Et",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                List<Siparis> orders = mainController.getSiparisListesi();
                for (int i = 0; i < orders.size(); i++) {
                    if (orders.get(i).getMusteriAdi().equalsIgnoreCase(musteriAdi)) {
                        orders.remove(i);
                        break;
                    }
                }
                refreshSiparisTable();
                JOptionPane.showMessageDialog(this, "Sipariş başarıyla silinmiştir.", "İptal Edildi", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return mainPanel;
    }

    private void filterTable() {
        String query = txtSiparisAra.getText().trim();
        if (query.isEmpty()) {
            sorterSiparisler.setRowFilter(null);
        } else {
            sorterSiparisler.setRowFilter(RowFilter.regexFilter("(?i)" + query, 0));
        }
    }

    private void refreshSiparisTable() {
        if (modelSiparisler == null) return;

        modelSiparisler.setRowCount(0);
        double ciro = 0;
        int count = 0;

        for (Siparis s : mainController.getSiparisListesi()) {
            double toplam = s.toplamTutarHesapla();
            ciro += toplam;
            count++;

            modelSiparisler.addRow(new Object[]{
                    s.getMusteriAdi(),
                    s.getTelefon(),
                    s.getAdres(),
                    s.getPaketAdi(),
                    s.getDetaylar(),
                    s.getDavetliSayisi(),
                    s.getHesaplananKisiUcreti() + " TL",
                    toplam + " TL"
            });
        }

        lblToplamSiparisSayisi.setText("Toplam Sipariş: " + count);
        lblToplamCiro.setText("Toplam Ciro: " + ciro + " TL");
    }

    private JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(COLOR_WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 234, 238), 1, true),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        return panel;
    }

    private void styleTextField(JTextField tf) {
        tf.setFont(FONT_BODY);
        tf.setForeground(COLOR_TEXT_DARK);
        tf.setBackground(COLOR_WHITE);
        Border margin = BorderFactory.createEmptyBorder(8, 12, 8, 12);
        Border line = BorderFactory.createLineBorder(new Color(209, 216, 224), 1, true);
        tf.setBorder(BorderFactory.createCompoundBorder(line, margin));
    }

    private void stylePasswordField(JPasswordField pf) {
        pf.setFont(FONT_BODY);
        pf.setForeground(COLOR_TEXT_DARK);
        pf.setBackground(COLOR_WHITE);
        Border margin = BorderFactory.createEmptyBorder(8, 12, 8, 12);
        Border line = BorderFactory.createLineBorder(new Color(209, 216, 224), 1, true);
        pf.setBorder(BorderFactory.createCompoundBorder(line, margin));
    }

    private void styleComboBox(JComboBox<?> cb) {
        cb.setFont(FONT_BODY);
        cb.setForeground(COLOR_TEXT_DARK);
        cb.setBackground(COLOR_WHITE);
        cb.setBorder(BorderFactory.createLineBorder(new Color(209, 216, 224), 1));
    }

    private void styleRadioButton(JRadioButton rb) {
        rb.setFont(FONT_BODY);
        rb.setForeground(COLOR_TEXT_DARK);
        rb.setBackground(COLOR_WHITE);
        rb.setFocusPainted(false);
    }

    private void styleTable(JTable table) {
        table.setRowHeight(32);
        table.setFont(FONT_BODY);
        table.setForeground(COLOR_TEXT_DARK);
        table.setSelectionBackground(new Color(225, 235, 245));
        table.setSelectionForeground(COLOR_PRIMARY);
        table.setGridColor(new Color(241, 242, 246));
        table.setShowVerticalLines(false);

        JTableHeader header = table.getTableHeader();
        header.setFont(FONT_BODY_BOLD);
        header.setBackground(COLOR_PRIMARY);
        header.setForeground(COLOR_WHITE);
        header.setPreferredSize(new Dimension(0, 38));

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(COLOR_PRIMARY);
        headerRenderer.setForeground(COLOR_WHITE);
        headerRenderer.setFont(FONT_BODY_BOLD);
        headerRenderer.setHorizontalAlignment(JLabel.LEFT);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    class ModernButton extends JButton {
        private Color normalBg;
        private Color hoverBg;

        public ModernButton(String text, Color bg, Color fg) {
            super(text);
            this.normalBg = bg;
            this.hoverBg = bg.brighter();

            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(true);
            setBackground(bg);
            setForeground(fg);
            setFont(FONT_BODY_BOLD);
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            setCursor(new Cursor(Cursor.HAND_CURSOR));

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    setBackground(hoverBg);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(normalBg);
                }
            });
        }

        public void setHoverBg(Color hoverBg) {
            this.hoverBg = hoverBg;
        }
    }

    class SidebarButton extends JButton {
        private boolean active = false;
        private Color hoverBg = new Color(52, 73, 94);
        private Color activeBg = COLOR_ACCENT;

        public SidebarButton(String text) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(true);
            setBackground(COLOR_PRIMARY);
            setForeground(COLOR_WHITE);
            setFont(FONT_BODY);
            setHorizontalAlignment(SwingConstants.LEFT);
            setBorder(BorderFactory.createEmptyBorder(14, 25, 14, 25));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setMaximumSize(new Dimension(240, 50));

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!active) setBackground(hoverBg);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    if (!active) setBackground(COLOR_PRIMARY);
                }
            });
        }

        public void setActive(boolean active) {
            this.active = active;
            if (active) {
                setBackground(activeBg);
                setForeground(COLOR_PRIMARY_DARK);
                setFont(FONT_BODY_BOLD);
            } else {
                setBackground(COLOR_PRIMARY);
                setForeground(COLOR_WHITE);
                setFont(FONT_BODY);
            }
        }
    }

    class YemekComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof Yemek) {
                Yemek y = (Yemek) value;
                setText(y.getAd() + " (" + y.getFiyat() + " TL)");
            }
            return this;
        }
    }
}