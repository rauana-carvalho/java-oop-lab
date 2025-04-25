# ☕ Java OOP & Basics Lab

This repository contains exercises and example projects written in Java, focused on:

- 🧱 Object-Oriented Programming (OOP)
- 🧠 Core Java programming fundamentals
- ⚙️ Exception handling, packages, and clean code organization

---

## 📁 Structure

```
.
├── .gitignore                      # Git ignore rules
├── README.md                       # This document
├── introduction/
│   ├── Calculadora.java            # Basic arithmetic operations
│   └── Divisao.java                # Division with exception handling
├── sistemapagamento/              # Object-oriented employee payment system
│   ├── CalculoPagamento.class
│   ├── Funcionarios.class
│   └── SistemaPagamentoFuncionarios.class
├── aula/                           # In-class exercises (Portuguese: "aula" = lesson)
│   └── ...
```

- `.java`: Java source files  
- `.class`: Compiled Java classes (automatically generated)  
- `.gitignore`: Lists files and folders excluded from version control  
- `aula/`: Classroom or lesson-based activities

---

## 🔧 Prerequisites

- JDK 8 or higher  
- Environment variable `JAVA_HOME` properly set  
- (Optional) A Java IDE such as IntelliJ IDEA, Eclipse, or VS Code with the Java Extension Pack  

---

## ▶️ Compile & Run

### Compile a single file:
```bash
javac introduction/Calculadora.java
javac introduction/Divisao.java
```

### Run a compiled program:
```bash
java javaintroduction.Calculadora
java javaintroduction.Divisao
```

> Replace `javaintroduction` with the actual package name if different.

If the class is inside a package:
```bash
java package.ClassName
```

---

## 🚧 Contribution Guidelines

1. Fork this repository  
2. Create a new branch for your exercise or feature:
   ```bash
   git checkout -b feature/your-topic-name
   ```
3. Write your code, include comments and examples if needed  
4. Commit using clear, conventional messages:
   ```
   feat: add inheritance example with abstract classes
   ```
5. Open a Pull Request and describe your contribution

---

## 📝 Notes

This repository serves as a growing archive of Java examples for me and many other java learners, especially within the context of Object-Oriented Programming (OOP).

New topics and exercises will be added over time!