import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Base64;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.border.TitledBorder;

public class BusinessCardCreator extends JFrame {
    private JTextField nameField, orgField, titleField, phoneField, emailField;
    private JLabel imagePreview;
    private JButton previewButton;
    private File selectedImageFile;

    private void selectImageFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "jpeg", "png"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedImageFile = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(selectedImageFile);
                if (image != null) {
                    imagePreview.setIcon(new ImageIcon(image.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    imagePreview.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "The selected file is not a valid image.", "Invalid File", JOptionPane.ERROR_MESSAGE);
                    selectedImageFile = null;
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading the image file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
                selectedImageFile = null;
            }
        }
    }

    public BusinessCardCreator() {
        setTitle("Business card creator");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        mainPanel.setBackground(new Color(10, 58, 18));

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(10, 54, 18), 13),
                "Personal Information", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Times New Roman", Font.BOLD, 50), new Color(15, 38, 22)));
        formPanel.setBackground(new Color(224, 246, 185));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 15, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add labels and fields
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Full Name:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        nameField = new JTextField(30);
        nameField.setBackground(new Color(251, 251, 237));
        nameField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        nameField.setForeground(Color.BLACK);
        nameField.setBorder(BorderFactory.createLineBorder(new Color(16, 30, 16), 2));
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Organization:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        orgField = new JTextField(30);
        orgField.setBackground(new Color(251, 251, 237));
        orgField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        orgField.setForeground(Color.BLACK);
        orgField.setBorder(BorderFactory.createLineBorder(new Color(16, 30, 16), 3));
        formPanel.add(orgField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Job Title:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        titleField = new JTextField(30);
        titleField.setBackground(new Color(251, 251, 237));
        titleField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        titleField.setForeground(Color.BLACK);
        titleField.setBorder(BorderFactory.createLineBorder(new Color(16, 30, 16), 3));
        formPanel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Phone Number:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        phoneField = new JTextField(30);
        phoneField.setBackground(new Color(251, 251, 237));
        phoneField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        phoneField.setForeground(Color.BLACK);
        phoneField.setBorder(BorderFactory.createLineBorder(new Color(16, 30, 16), 3));
        formPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(createLabel("Email Address:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        emailField = new JTextField(30);
        emailField.setBackground(new Color(251, 251, 237));
        emailField.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        emailField.setForeground(Color.BLACK);
        emailField.setBorder(BorderFactory.createLineBorder(new Color(16, 30, 16), 3));
        formPanel.add(emailField, gbc);

        // Image button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JButton imageButton = new JButton("Browse");
        imageButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        imageButton.setBackground(new Color(169, 239, 191));
        imageButton.setForeground(new Color(10, 46, 12));
        imageButton.setPreferredSize(new Dimension(150, 40));
        imageButton.addActionListener(e -> selectImageFile());
        formPanel.add(imageButton, gbc);

        // Image preview
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        imagePreview = new JLabel("No Image Selected", SwingConstants.CENTER);
        imagePreview.setPreferredSize(new Dimension(150, 150));
        imagePreview.setOpaque(true);
        imagePreview.setBackground(new Color(251, 251, 237));
        imagePreview.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        formPanel.add(imagePreview, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(new Color(242, 246, 185));

        JButton generateButton = new JButton("Generate VCF");
        generateButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        generateButton.setBackground(new Color(169, 239, 191));
        generateButton.setForeground(new Color(10, 58, 12));
        generateButton.addActionListener(e -> generateVCard());
        buttonPanel.add(generateButton);

        previewButton = new JButton("Preview Surat");
        previewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        previewButton.setBackground(new Color(169, 239, 191));
        previewButton.setForeground(new Color(10, 58, 12));
        previewButton.addActionListener(e -> previewVCard());
        buttonPanel.add(previewButton);

        // Add panels
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Times New Roman", Font.BOLD, 22));
        return label;
    }

    private void generateVCard() {
        String name = nameField.getText();
        String organization = orgField.getText();
        String title = titleField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        if (name.isEmpty() || organization.isEmpty() || title.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled in.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder vCardBuilder = new StringBuilder();
        vCardBuilder.append("BEGIN:VCARD\n");
        vCardBuilder.append("VERSION:3.0\n");
        vCardBuilder.append("FN:").append(name).append("\n");
        vCardBuilder.append("ORG:").append(organization).append("\n");
        vCardBuilder.append("TITLE:").append(title).append("\n");
        vCardBuilder.append("TEL:").append(phone).append("\n");
        vCardBuilder.append("EMAIL:").append(email).append("\n");

        if (selectedImageFile != null) {
            String base64Image = encodeImageToBase64(selectedImageFile);
            if (base64Image != null) {
                vCardBuilder.append("PHOTO;ENCODING=BASE64;TYPE=").append(getFileExtension(selectedImageFile)).append(":");
                vCardBuilder.append(splitBase64String(base64Image));
                vCardBuilder.append("\n");
            }
        }

        vCardBuilder.append("END:VCARD\n");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save VCF File");
        fileChooser.setSelectedFile(new File("business_card.vcf"));
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (FileWriter writer = new FileWriter(fileToSave)) {
                writer.write(vCardBuilder.toString());
                JOptionPane.showMessageDialog(this, "VCF file generated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                previewButton.setEnabled(true);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving VCF file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private String getFileExtension(File file) {
        String fileName = file.getName();
        int lastIndexOfDot = fileName.lastIndexOf('.');
        return (lastIndexOfDot == -1) ? "" : fileName.substring(lastIndexOfDot + 1).toLowerCase();
    }

    private void previewVCard() {
        JDialog previewDialog = new JDialog(this, "Preview V-Card", true);
        previewDialog.setLayout(new BorderLayout());
        previewDialog.setSize(750, 410);
        previewDialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage background = ImageIO.read(new File("/home/admin123/IdeaProjects/Surat_card/src/resources/background_image.jpg"));
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        panel.setLayout(new BorderLayout(15, 15));
        panel.setOpaque(false);

        JTextArea previewArea = new JTextArea(2, 20);
        previewArea.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        previewArea.setEditable(false);
        previewArea.setBackground(new Color(251, 251, 237));
        previewArea.setForeground(new Color(16, 30, 16));
        previewArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(16, 54, 18), 3),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        StringBuilder vCardPreview = new StringBuilder();
        vCardPreview.append("Full Name: ").append(nameField.getText()).append("\n");
        vCardPreview.append("Organization: ").append(orgField.getText()).append("\n");
        vCardPreview.append("Job Title: ").append(titleField.getText()).append("\n");
        vCardPreview.append("Phone Number: ").append(phoneField.getText()).append("\n");
        vCardPreview.append("Email Address: ").append(emailField.getText()).append("\n");
        previewArea.setText(vCardPreview.toString());

        JScrollPane scrollPane = new JScrollPane(previewArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        if (selectedImageFile != null) {
            JLabel imageLabel = new JLabel();
            try {
                BufferedImage image = ImageIO.read(selectedImageFile);
                if (image != null) {
                    imageLabel.setIcon(new ImageIcon(image.getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
                    imageLabel.setText("");
                } else {
                    imageLabel.setText("Invalid Image");
                }
            } catch (IOException e) {
                imageLabel.setText("Error Loading Image");
            }
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setPreferredSize(new Dimension(250, 250));
            imageLabel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(16, 54, 18), 0),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));
            panel.add(imageLabel, BorderLayout.WEST);
        }

        panel.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
        closeButton.setBackground(new Color(169, 239, 191));
        closeButton.setForeground(new Color(10, 46, 12));
        closeButton.setPreferredSize(new Dimension(120, 40));
        closeButton.addActionListener(e -> previewDialog.dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        buttonPanel.add(closeButton);

        previewDialog.setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    BufferedImage background = ImageIO.read(new File("/home/admin123/IdeaProjects/Surat_card/src/resources/background_image.jpg"));
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        previewDialog.getContentPane().setLayout(new BorderLayout());
        previewDialog.getContentPane().add(panel, BorderLayout.CENTER);
        previewDialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        previewDialog.setVisible(true);
    }

    private String encodeImageToBase64(File file) {
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] imageBytes = inputStream.readAllBytes();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error encoding image to Base64: " + e.getMessage(),
                    "Encoding Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private String splitBase64String(String base64) {
        StringBuilder result = new StringBuilder();
        int length = base64.length();
        int lineSize = 75;
        for (int i = 0; i < length; i += lineSize) {
            result.append(base64, i, Math.min(i + lineSize, length)).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BusinessCardCreator::new);
    }
}