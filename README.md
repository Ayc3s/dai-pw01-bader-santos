<div style="display: flex; align-items: center; justify-content: space-between;">
  <img src="img/heig_logo.png" alt="Wiki CLI Logo" width="200" height="100" style="border-radius: 10px;"/>
  <h1>DAI 2025 - project 01 - Bader Gabriel Santos Mauro</h1>
</div>

**Wiki** is a Java-based command-line application designed to help users easily manage personal notes or structured information — much like a simplified offline wiki system.
It allows you to create, read, update, and delete text-based entries stored in a plain .txt file, using simple terminal commands.

It was developped with Maven for project management and Picocli for command-line.

---

# Goal of the project

- Gain hands-on experience with Maven and Picocli.
- Design a simple, functional command-line application.
- Apply a collaborative workflow with github.

---

# Author

HEIGVD - 2025 DAI

**Gabriel Bader**

**Mauros Santos**

---


# Main features


| Mode      | Command                                     | Description                |
| --------- | ------------------------------------------- | -------------------------- |
| `SHOWALL` | `--showall`                                 | Displays all wiki entries  |
| `ADD`     | `--ADD "Name Description"`                  | Adds a new entry           |
| `MODIFY`  | `--MODIFY "OldName NewName NewDescription"` | Modifies an existing entry |
| `SHOW`    | `--SHOW "Name"`                             | Displays a specific entry  |
| `DELETE`  | `--DELETE "Name"`                           | Deletes an entry           |


Quick exemple:
``` bash
dai-pw01-bader-santos.jar --show nano
output: nano : will open an interface that allow you to read/modify a file
```
---

# CLI usage

``` bash

Usage: dai-pw01-bader-santos.jar [COMMAND]
java -jar java-intellij-idea-and-maven-1.0-SNAPSHOT.jar --help
Usage: Wiki [-hV] [-sa] [-a=<add>] [-del=<delete>] [-m=<modifiy>] [-sh=<show>]
            <filePath>
Open and create you own wiki
      <filePath>           Destination file of the wiki, by default, will be
                             written in default project folder
                             Default: wiki.txt
  -a, --ADD=<add>          Add new entry to the wiki:
                            Arg1 : entry name
                            Arg2 : Description
                            Exemple : --a "nano myNewDescription"
      -del, --DELETE=<delete>
                           Delete an existing entry :
                            Exemple: --del "name"
  -h, --help               Show this help message and exit.
  -m, --MODIFY=<modifiy>   Modify an existing entry : --m "nameWikiEntry
                             newName myNewDescription"
                           Exemple : --m nano nanov2 "new decription"
      -sa, --showall       Show all entry of the wiki
      -sh, --SHOW=<show>   Show an existing entry :
                            Exemple: --sh "name"
  -V, --version            Print version information and exit.

```
---

# Exemple

In this section, we will see a detailed exemple of the usage of our **wiki** :

1. Empty textfile at the root of the directory :
2. add multiple entries
3. Modify an existing entries
4. Show all
5. Delete an entry
6. Show specifc entry



# To continue

As mentioned earlier in the Goal section, this project was a valuable first experience with Java and various tools such as Maven and Picocli.
We are pleased with the outcome of this work; however, as an introductory project, we did not go as far as we originally intended.

For future improvements, we would like to:

- Refine the overall structure of the application

- Add support for categories and keyword-based search

- Improve user interaction and data organization

- Upgrade to a better system : not .txt file

And many other aspect of a real command-line wiki.



# AI use

For this project, the only use of AI was:

- The example for the enum (explained in the code)
  - Quick summary: AI showed us a way to implement an enum that allows a switch over all the commands. We did not copy/past, only took exemple of it

AI helped us correct English grammar in the README. (We want to point out that we wrote it first.)