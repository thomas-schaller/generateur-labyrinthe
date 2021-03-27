import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.print.PageFormat
import java.awt.print.Printable
import javax.swing.JComponent
import java.awt.Color




class LabyrinthePicture(val labyrinthe: Labyrinthe) : JComponent(), Printable {
    val coteCarre=10;
    val marge= coteCarre/2
    init {
        setSize(labyrinthe.tailleX*coteCarre+marge*2+10,labyrinthe.tailleY*coteCarre+marge*2+40)
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        val g2d= g as Graphics2D
        drawLabyrinthe(g2d)
    }

    fun drawLabyrinthe(g2d:Graphics2D)
    {
        //Bordure Nord
        for (x in 0..labyrinthe.tailleX-1)
        {
            if (labyrinthe.murHorizontal[x][0] == false)
            {
                g2d.drawLine(x*coteCarre+marge,marge,(x+1)*coteCarre+marge,marge)
            }

        }
        for (y in 0..labyrinthe.tailleY-1)
        {

            for (x in 0..labyrinthe.tailleX-1)
            {
                if (!labyrinthe.getEtatMur(Point(x,y),Direction.OUEST))
                {
                    g2d.drawLine(x*coteCarre+marge,y*coteCarre+marge,x*coteCarre+marge,(y+1)*coteCarre+marge)
                }

                if (!labyrinthe.getEtatMur(Point(x,y),Direction.SUD))
                {
                    g2d.drawLine(x*coteCarre+marge,(y+1)*coteCarre+marge,(x+1)*coteCarre+marge,(y+1)*coteCarre+marge)
                }

                //bordure Est
                if (x==labyrinthe.tailleX-1 && !labyrinthe.getEtatMur(Point(x,y),Direction.EST))
                {
                    g2d.drawLine((x+1)*coteCarre+marge,y*coteCarre+marge,(x+1)*coteCarre+marge,(y+1)*coteCarre+marge)
                }

            }
        }
    }


    override fun print(graphics: Graphics, pageFormat: PageFormat, pageIndex: Int): Int {
        val g2 = graphics as Graphics2D
        g2.translate(
            pageFormat.imageableX + pageFormat.imageableWidth
                    / 2 - width / 2, pageFormat.imageableY
        )
        if (pageIndex > 0) return Printable.NO_SUCH_PAGE
        printAll(graphics)
        graphics.color = Color.BLACK
        return Printable.PAGE_EXISTS
    }
}