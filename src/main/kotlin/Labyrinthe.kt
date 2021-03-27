import java.lang.Math.abs

class Labyrinthe constructor(val tailleX : Int, val tailleY : Int){
    val murHorizontal : Array< Array<Boolean>> = Array(tailleX){Array(tailleY+1){false} }
    val murVertical :Array< Array<Boolean>> = Array(tailleX+1){Array(tailleY){false} }


    fun setEtatMur(position:Point,direction:Direction,estOuvert:Boolean)
    {
        if (direction.equals(Direction.NORD))
        {
            murHorizontal[position.x][position.y]=estOuvert
        }
        else if(direction.equals(Direction.SUD))
        {
            murHorizontal[position.x][position.y+1] = estOuvert
        }
        else if(direction.equals(Direction.OUEST))
        {
            murVertical[position.x][position.y] = estOuvert
        }
        else
        {
            murVertical[position.x+1][position.y] = estOuvert
        }
    }

    fun ouvrirMur(position:Point,direction:Direction)
    {
        setEtatMur(position,direction,true)
    }


    fun getEtatMur(position:Point,direction:Direction):Boolean{
        val etatMur: Boolean
        if (direction.equals(Direction.NORD))
        {
            etatMur=murHorizontal[position.x][position.y]
        }
        else if(direction.equals(Direction.SUD))
        {
            etatMur=murHorizontal[position.x][position.y+1]
        }
        else if(direction.equals(Direction.OUEST))
        {
            etatMur=murVertical[position.x][position.y]
        }
        else
        {
            etatMur=murVertical[position.x+1][position.y]
        }
        return etatMur;
    }


    override fun toString(): String {
        var resultat=""
        //Bordure Nord
        for (x in 0..tailleX-1)
        {
            if (murHorizontal[x][0] == false)
            {
                resultat+="._"
            }
            else
            {
                resultat+=". "
            }
        }
        resultat+=System.lineSeparator()
        for (y in 0..tailleY-1)
        {

            for (x in 0..tailleX-1)
            {
                if (!getEtatMur(Point(x,y),Direction.OUEST))
                {
                    resultat+="|"
                }
                else
                {
                    resultat+="."
                }
                if (!getEtatMur(Point(x,y),Direction.SUD))
                {
                    resultat+="_"
                }
                else
                {
                    resultat+=" "
                }
                //bordure Est
                if (x==tailleX-1 && !getEtatMur(Point(x,y),Direction.EST))
                {
                    resultat+="|"
                }

            }
            resultat+=System.lineSeparator()
        }

        return resultat
    }
}

