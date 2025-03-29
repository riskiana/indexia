## 📖 Overview

Indexia is a lightweight Java application that processes text files and applies customizable indexing rules to analyze content. It provides structured logging output and supports multiple rule-based text analysis operations.

## ✨ Features

- Processes multiple text files in a single run
- Applies configurable indexing rules
- Easy to extend with custom rules
- Simple command-line interface
- Supports txt, html, and xml files

## 🚀 Usage
java -jar indexia.jar file1.txt file2.html

## 🛠️ How to create a custom rule
- Create a new class that implements the `Rule` interface
- Implement the `apply` method to define the rule logic
- Add the new rule to the rules list in the `App` class