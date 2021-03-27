class ParcoursProfondeur(val longueur:Int, val largeur:Int):LabyrintheGenerateur {
    override fun generate(): Labyrinthe {
        val labyrinthe = Labyrinthe(longueur,largeur)
        val caseVisite : Array< Array<Boolean>> = Array(longueur){Array(largeur){false} }
        val elementEnTraitement = ArrayDeque<Point>()
        var position =  Point((0..longueur-1).random(),(0..largeur-1).random());
        caseVisite[position.x][position.y]=true;
        elementEnTraitement.add(position);
        while (!elementEnTraitement.isEmpty())
        {
            val choixPossibles = ArrayDeque<Direction>();
            position =elementEnTraitement.last();
            if (position.x-1 >= 0 && !caseVisite[position.x-1][position.y])
            {
                choixPossibles.add(Direction.OUEST)
            }
            if (position.y-1 >= 0 && !caseVisite[position.x][position.y-1])
            {
                choixPossibles.add(Direction.NORD)
            }
            if (position.x+1 < longueur && !caseVisite[position.x+1][position.y])
            {
                choixPossibles.add(Direction.EST)
            }
            if (position.y+1 < largeur && !caseVisite[position.x][position.y+1])
            {
                choixPossibles.add(Direction.SUD)
            }
            if (choixPossibles.isEmpty())
            {
                elementEnTraitement.removeLast();
            }
            else
            {
                val direction=choixPossibles.get((0..choixPossibles.size-1).random());
                labyrinthe.ouvrirMur(position,direction);
                position = calculerNouvellePosition(position,direction)
                caseVisite[position.x][position.y]=true
                elementEnTraitement.add(position);
            }
        }
        // on ouvre un mur en bordure supérieur
        labyrinthe.ouvrirMur(Point((0..longueur-1).random(),0),Direction.NORD)
        // on ouvre un mur en bordure inférieure
        labyrinthe.ouvrirMur(Point((0..longueur-1).random(),largeur-1),Direction.SUD)
        return labyrinthe;
    }

    private fun calculerNouvellePosition(position:Point,direction:Direction):Point{
        var resultat =Point(position.x-1,position.y)
        if (direction.equals(Direction.NORD))
        {
            resultat = Point(position.x,position.y-1)
        }
        if (direction.equals(Direction.SUD))
        {
            resultat = Point(position.x,position.y+1)
        }
        if (direction.equals(Direction.EST))
        {
            resultat = Point(position.x+1,position.y)
        }
        return resultat;
    }
}