import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import javax.imageio.ImageIO

import java.io.File

import java.awt.Color

import java.awt.Graphics

import java.awt.image.BufferedImage




fun main() {
    val generateur : LabyrintheGenerateur ;
    generateur =  ParcoursProfondeur(100,100)
    val laby=generateur.generate()
    print(laby)
    val frame = JFrame();
    val panel = LabyrinthePicture(laby)
    frame.contentPane.add(panel,BorderLayout.CENTER)
    frame.setSize(frame.preferredSize)
    frame.isVisible=true
    frame.defaultCloseOperation=EXIT_ON_CLOSE
    val tamponSauvegarde = BufferedImage(
        panel.getSize().width,
        panel.getSize().height, BufferedImage.TYPE_INT_ARGB
    )
    val g = tamponSauvegarde.graphics

    panel.print(g)
    var fichierImage: File = File("labyrinthe.png")
    ImageIO.write(tamponSauvegarde, "PNG", fichierImage)
}