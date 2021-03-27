class StaticLabyrintheGenerateur() :LabyrintheGenerateur
{
    override fun generate(): Labyrinthe
    {
        val labyrinthe = Labyrinthe(4,4)
        labyrinthe.ouvrirMur(Point(0,0),Direction.NORD);
        labyrinthe.ouvrirMur(Point(0,0),Direction.EST);
        labyrinthe.ouvrirMur(Point(1,0),Direction.SUD);
        labyrinthe.ouvrirMur(Point(1,0),Direction.EST);
        labyrinthe.ouvrirMur(Point(2,0),Direction.SUD);
        labyrinthe.ouvrirMur(Point(0,1),Direction.EST);
        labyrinthe.ouvrirMur(Point(0,1),Direction.SUD);
        labyrinthe.ouvrirMur(Point(3,1),Direction.SUD);
        labyrinthe.ouvrirMur(Point(2,2),Direction.OUEST);
        labyrinthe.ouvrirMur(Point(2,2),Direction.NORD);
        labyrinthe.ouvrirMur(Point(2,2),Direction.EST);
        labyrinthe.ouvrirMur(Point(3,2),Direction.SUD);
        labyrinthe.ouvrirMur(Point(3,2),Direction.NORD);
        labyrinthe.ouvrirMur(Point(1,3),Direction.EST);
        labyrinthe.ouvrirMur(Point(2,3),Direction.SUD);
        labyrinthe.ouvrirMur(Point(1,3),Direction.OUEST);
        labyrinthe.ouvrirMur(Point(3,3),Direction.OUEST);
        return labyrinthe
    }
}