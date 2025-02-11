# Digital Clock App

![License](https://img.shields.io/badge/license-MIT-blue.svg) 
![Java](https://img.shields.io/badge/language-Java-orange.svg)
![Swing](https://img.shields.io/badge/library-Java%20Swing-yellowgreen.svg)

A simple and elegant digital clock application built using Java Swing. This application displays the current time in a large, resizable font and dynamically adjusts the font size when the window is resized.

---

## Table of Contents

- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Customization](#customization)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## Features

- **Real-Time Clock:** Displays the current time in `HH:mm:ss` format.
- **Dynamic Font Resizing:** Automatically adjusts the font size when the window is resized.
- **Custom Font:** Uses a custom TrueType font (`BitFont.ttf`) for a unique look.
- **Sleek Design:** Minimalist and visually appealing user interface.

---

## Installation

To run the Digital Clock App, follow these steps:

1. **Ensure Java is installed:**
   Make sure you have Java installed on your system. You can check by running:
   ```bash
   java -version

2. **Clone the repository:**
   ```bash
   git clone https://github.com/M1keEm/DigitalClock.git
   
3. **Navigate to the project directory:**
   ```bash
   cd DigitalClock
   
4. **Download the custom font you've chosen**
   Downlaod the BitFont.ttf file and place it in the root directory of the project.
   
5. **Compile and run the application:**
   ```bash
   javac DigitalClock.java
   java DigitalClock

---

## Usage

Once the application is running, you will see a window displaying the current time in a large, resizable font.

- **Resize the Window:** Drag the edges of the window to resize it. The font size will automatically adjust to fit the new dimensions.

- **Close the Application:** Click the close button (X) on the window to exit the application.

---

## Customization

Changing the font:

1. **Replace the BitFont.ttf file with your desired TrueType font file.**
2. **Update the font loading code in the DigitalClockApp constructor:**
   ```java
   Font myFont = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/YourFontFile.ttf"));
   
Changing the colors:

You can customize the background and text colors by **modifying the following lines in the DigitalClockApp constructor:**
   ```java
   timeLabel.setBackground(Color.MAGENTA); // Change background color
   timeLabel.setForeground(Color.BLACK);  // Change text color;
   ```

---

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeatureName`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeatureName`).
5. Open a pull request.

Please ensure your code follows the existing style and includes appropriate documentation.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

If you have any questions or suggestions, feel free to reach out:

- **MikeEm** - [My Github](https://github.com/m1keem)
- **Project Link** - [Repository](https://github.com/m1keem/digitalclock)
