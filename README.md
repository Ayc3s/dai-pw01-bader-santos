# DAI 2025 - project 01 - Bader Santos

---

# Description

A simple CLI wiki that allows the user to :
- add
- modify
- delete
- show
his own articles.

*By articles, we mean : Command, Own wiki, Post, Topics, ...*

Exemple:
``` bash
dai-pw01-bader-santos.jar --show nano
    nano : will open an interface that wiil allow you to read/modify a file
```
---

# CLI usage
``` bash

Usage: dai-pw01-bader-santos.jar [COMMAND]
A small CLI with subcommands to demonstrate picocli.
  --new <name>      Adds a new article.
  --modify <name>   Modifies an existing article.
  --delete <name>   Deletes an existing article.
  --show <name>     Shows information of an existing article.
  -a --showall      Shows list of all articles.
  -h, --help        Show this help message and exit.
  -V, --version     Print version information and exit.
```

