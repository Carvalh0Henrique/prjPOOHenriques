# Trabalho de POO - Sistema de Clínica 

## 📖 Descrição

Este projeto é a implementação do Trabalho da disciplina de Programação Orientada a Objetos. O objetivo é implementar em Java um sistema de gerenciamento de clínica, baseado em um diagrama de classes UML fornecido.

O sistema modela as seguintes entidades e seus relacionamentos:
* `Pessoa` 
* `Medico` 
* `Paciente`
* `Consulta`
* `Exame`
* `Medicacao`

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK-8u192)
* **IDE:** Netbeans 8.2 
* **Bibliotecas:**
    * `java.time.LocalDate` (para o atributo `dataNascimento`) 
    * `java.util.ArrayList` (para implementar multiplicidades 0..* e 1..*) 

## ⚙️ Passos para Rodar o Projeto

1.  Certifique-se de ter o **Netbeans 8.2** instalado.
2.  Clone este repositório para sua máquina local.
3.  Abra o Netbeans IDE.
4.  Vá em `Arquivo > Abrir Projeto...` e selecione a pasta raiz do projeto (`prjPOOHenriques`).
5.  O projeto será carregado automaticamente.

## 📁 Estrutura do Projeto

O projeto segue a estrutura da aquitetura MVC:

```
prjPOOHenriques/
│
├── build.xml
├── manifest.mf
├── nbproject/
│   ├── (Arquivos de configuração do Netbeans)
│   └── ...
│
├── src/
│   └── fatec/
│       └── poo/
│           ├── model/
│           │   ├── Pessoa.java       
│           │   ├── Medico.java   
│           │   ├── Paciente.java 
│           │   ├── Consulta.java 
│           │   ├── Exame.java    
│           │   └── Medicacao.java
│           │
│           ├── view/
│           │   └── Interfaces JFrame
│           │
│           └── controller/
│                └── Classes que conectam a lógica (Model) com a tela (View)
│
└── README.md
```