# PracticaUF2-M03

He desenvoplupat una aplicació fitness modular en Java. L'objectiu de l'aplicació és  proporcionar consells d'entrenament i nutrició per ajudar als usuaris
a millorar la seva salut i condició física.

El programa compta amb diferents mètodes: 

- Primer hi ha un menú principal que s'executa amb un do-while fins que l'usuari desitji sortir de l'aplicació, dins el  menú principal l'usuari pot escollir si 
introduir les seves dades, introduir les dades per calcular l'IMC, calcular l'IMC, calcular la composició corporal, escollir el tipus d'entrenament, mostrar la
planificació o sortir.

- Mètode dadesBasiques: Aquest mètode demana a l'usuari que introdueixi les seves dades bàsiques, com ara el nom, els cognoms, el DNI i el correu electrònic.
Aquestes dades s'emmagatzemen en un ArrayList.

- Mètode preguntarMassaCorporal: Aquest mètode recursiu  demana a l'usuari que introdueixi les seves dades de pes, alçada, edat i gènere, i les emmagatzema en un
vector de tipus float. 

- Mètode calcularMassaCorporal: Aquest mètode calcula el valor de l'Índex de Massa Corporal (IMC) a partir de les dades de pes i alçada obtingudes al mètode.

- Mètode resultatIMC: Aquest mètode determina el resultat del càlcul de l'IMC de l'usuari

-Mètode controlErrors: Aquest mètode serveix per a què les dades que introdueix l'usuari siguin correctes, demana un String un valor mínim i un màxim, 
si el nombre de tipus float introduit no està dins del rang demanat retorna un error.

- Mètode tipusEntrenament: Aquest mètode mostra una llista de diferents tipus d'entrenaments i pregunta a l'usuari quin prefereix .

- Mètode entrenamentEscollit: Serveix per escollir el tipus d'entrenament.

- Mètode entrenamentPersonalitzat rep un array de valors flotants "imc" que representa els índexs de massa corporal de l'usuari, depenent de l'Imc de l'ususari 
i del tipus d'entrenament escollit retorna uns exercicis diferents.

- Mètode planningFinal: Aquest mètode genera un pla d'entrenament personalitzat a partir de les dades bàsiques i el càlcul de l'IMC de l'usuari.

