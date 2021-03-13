# Introduction

Dépôt pour mes notes de cours à l'ESI. Tous les cours ne sont pas là,
parfois par manque de temps, parfois parce qu'il y a suffisamment de
supports sur la plate-forme que la création de nouvelles notes n'en
vaut pas la peine. 

Dans tous les cas, ces notes sont écrites pour et par moi, sans
garantie d'exactitude quant au contenu. À utiliser avec prudence,
allez au cours. 

# Utilisation 

Simplement cliquer et télécharger un fichier est possible. Cela dit,
ce que je conseille de faire est :

``` shell
git clone https://git.esi-bru.be/55803/notes-esi.git
```

Pour télécharger le dépôt pour la première fois. Une fois téléchargé,
utiliser, dans le répertoire `notes-esi`. 

``` shell
git pull
```

Pour le mettre à jour avec mes dernières notes publiées sur le
dépôt. Ceci nécessite d'installer `git`, voir [sur la page
officielle](https://git-scm.com/downloads). 

## Contenu 

Voici les notes disponibles actuellement :

``` shell
├── ALG2
│   └── ALG2.pdf
├── ANA2
│   └── ANA2.pdf
├── DEV2
│   └── DEV2.pdf
├── MIC2
│   ├── MIC2-labo.pdf
│   └── MIC2.pdf
├── README.md
├── SYS2
│   └── SYS2.pdf
└── WEBG2
```

## Erreurs 

Si vous trouvez des erreurs, vous pouvez bien entendu aider à corriger
les documents en ouvrant une
[issue](https://git.esi-bru.be/55803/notes-esi/-/issues), qui se
trouve dans l'onglet à gauche. 

# Comment les notes sont faites ? 

Pour créer les notes, j'ai utilisé l'éditeur de texte
[Emacs](https://www.gnu.org/software/emacs/) qui me permet de
travailler avec des fichiers textes très facilement et d'insérer du
code dedans. Ce processus passe par l'usage d'un outil excellent de
Emacs, appelé [org-mode](https://orgmode.org/). Enfin, pour exporter
en PDF, j'utilise
[LaTeX](https://www.latex-project.org/). L'utilisation de Emacs
dépasse le cadre de ce dépôt mais les personnes intéressées par
l'usage que j'en fait peuvent consulter ma [configuration
Emacs](https://gitlab.com/nathanfurnal/dotemacs). 
