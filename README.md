# Business Card Creator

**Business Card Creator** is a Java Swing-based desktop application designed to help users easily create and preview digital business cards (VCF files). The application allows users to input key details, add a profile image, and generate a visual preview of their business card, simplifying the VCF creation process.

---

## Features

- **Graphical User Interface (GUI):** User-friendly interface built with Java Swing, allowing easy input and customization of business card details.
- **Personal Information Fields:** Enter key information such as:
  - Full Name
  - Organization
  - Job Title
  - Phone Number
  - Email Address
- **Image Attachment:** Ability to upload a profile picture that gets encoded into VCF format.
- **Preview Feature:** View the business card's design and layout before saving the file.
- **VCF File Generation:** Create a `.vcf` file with the specified details in the standardized VCF format.

---

## Tech Stack

- **Programming Language:** Java (JDK 21)
- **GUI Framework:** Swing
- **Image Processing Libraries:** AWT and ImageIO for handling profile pictures and backgrounds.
- **File Handling:** Base64 encoding for embedding images into the VCF file.

---

## Requirements

- Java Development Kit (JDK) version 21 or above.
- Compatible with any operating system supporting JDK.

---

## How to Use

1. **Launch the Application:** Run the `BusinessCardCreator` class.
2. **Enter Your Details:** Fill in the name, job title, organization, phone number, and email address fields.
3. **Add a Profile Picture (Optional):**
   - Click the "Select Image" button to upload a profile picture.
   - Supported formats: `.jpg`, `.png`, etc.
4. **Preview Your V-Card:** Click the "Preview" button to view your business card layout.
5. **Generate the VCF File:** Your VCF file will include all entered details and the profile picture in Base64 format.

---

## Example Workflow

1. Enter "John Doe" as the Full Name.
2. Enter "Tech Solutions Inc." as the Organization.
3. Enter "Software Engineer" as the Job Title.
4. Provide a phone number and email address.
5. Upload a profile image using the "Select Image" button.
6. Click "Preview" to review your business card design.
7. Save the VCF file, ready for sharing.

---

## Key Classes and Methods

- `BusinessCardCreator`: Main application class containing the GUI setup and features.
- **Methods include:**
  - `selectImageFile()`: Facilitates image file selection.
  - `generateVCard()`: Creates the VCF file.
  - `previewVCard()`: Generates a preview of the business card.
  - `encodeImageToBase64(File file)`: Encodes the selected image as a Base64 string for VCF embedding.
  - `getFileExtension(File file)`: Retrieves the file extension for validation.

---

## Screenshots

_Include screenshots of the application (e.g., main screen, preview dialog, and an example of the generated business card)._

---

## Possible Enhancements

- Add support for more VCF fields, like social media links or website URLs.
- Integrate drag-and-drop functionality for image selection.
- Allow customization of card themes and colors.

---

## Credits

This project was developed as part of **"Internet and WWW 2024"**, **Lab Assignment 01**.

- **Developer:** Your Name
- **Faculty Number:** 7MI3400513
- **Semester:** Summer 2024
- **Program:** ZIKSM

---
