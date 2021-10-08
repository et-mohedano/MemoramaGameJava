/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvmemorama;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * Mendoza Hernández Dylan Michel
 * Mohedano Torres Efraín
 */
public class clsMemorama {
    // Atributos:
    List<JLabel> etiquetas;
    List<JButton> botones;
    List<JButton> tarjetas;
    JLabel etiqueta;
    JPanel panel;
    JButton boton;
    int numParesCorrectos;
    int numParesFallos;
    boolean inciar;
    int[][]numerosRandom;
    int[]tarjetasVolteadas;
    int numTarjetasVolteadas;
    String[]imagenesMemorama = {"/imagenes/1.png", "/imagenes/2.png", "/imagenes/3.png", "/imagenes/4.png"};

    int contSegundos;
    // Constructor:
    clsMemorama(){
        etiquetas = new ArrayList<>();
        tarjetas = new ArrayList<>();
        botones = new ArrayList<>();
        inciar = false;
        numerosRandom = new int[8][2];
        tarjetasVolteadas = new int[2];
        numParesCorrectos = 0;
        numParesFallos = 0;
        numTarjetasVolteadas = 0;
        contSegundos = 0;
    }
    
    public String[] getImagenesMemorama() {
        return imagenesMemorama;
    }

    public void setImagenesMemorama(String[] imagenesMemorama) {
        this.imagenesMemorama = imagenesMemorama;
    }

    public int getContSegundos() {
        return contSegundos;
    }

    public void setContSegundos(int contSegundos) {
        this.contSegundos = contSegundos;
    }

    public int[] getTarjetasVolteadas() {
        return tarjetasVolteadas;
    }

    public void setTarjetasVolteadas(int[] tarjetasVolteadas) {
        this.tarjetasVolteadas = tarjetasVolteadas;
    }

    public int[][] getNumerosRandom() {
        return numerosRandom;
    }

    public void setNumerosRandom(int[][] numerosRandom) {
        this.numerosRandom = numerosRandom;
    }
    // Setters and getters
    public List<JLabel> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<JLabel> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<JButton> getBotones() {
        return botones;
    }

    public void setBotones(List<JButton> botones) {
        this.botones = botones;
    }
    public boolean getIniciar() {
        return inciar;
    }

    public void setInciar(boolean iniciar) {
        this.inciar = iniciar;
    }
    public List<JButton> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<JButton> tarjetas) {
        this.tarjetas = tarjetas;
    }
    public int getNumParesCorrectos() {
        return numParesCorrectos;
    }

    public void setNumParesCorrectos(int numParesCorrectos) {
        this.numParesCorrectos = numParesCorrectos;
    }

    public int getNumParesFallos() {
        return numParesFallos;
    }

    public void setNumParesFallos(int numParesFallos) {
        this.numParesFallos = numParesFallos;
    }
    // Métodos
    public void crearPanel(JFrame frame){
        panel = new JPanel();
        panel.setName("jpanMain");
        panel.setSize(600, 430);
        panel.setLocation(0,0);
        panel.setBackground(Color.BLACK);
        panel.setOpaque(true);
        GroupLayout jPanelLayout = new GroupLayout(panel);
        panel.setLayout(jPanelLayout);
        panel.setVisible(true);
        frame.add(panel);
        
    }
    public void crearEtiquetas(){
        int[][]mPosicionesLabels = {{27, 22}, {218, 35}, {27, 135}, {170, 126}, {310, 126}, {450, 126}};
        int[][]mSizesLabels = {{176, 74}, {314, 48}, {126, 80}, {118, 48}, {128, 48}, {108, 48}};
        String[][]infoLabels = {{"jlblLogo", ""}, {"jlblTitulo", "Práctica No. 2 Memorama"}, {"jlblIntegrantes", "<html>Integrantes:<br>-Mendoza Hernández Dylan Michel<br>-Mohedano Torres Efraín</html>"}, {"jlblTimer",""}, {"jlblParejasEn",""}, {"jlblParejasFa", ""}};
        for (int i = 0; i < mPosicionesLabels.length; i++) {
            etiqueta = new JLabel();
            etiqueta.setName(infoLabels[i][0]);
            etiqueta.setText(infoLabels[i][1]);
            if (i == 1) {
                etiqueta.setFont(new Font("Serif", Font.BOLD, 28));
            }
            etiqueta.setBackground(Color.BLACK);
            etiqueta.setForeground(Color.white);
            etiqueta.setOpaque(true);
            etiqueta.setVisible(true);
            etiqueta.setSize(mSizesLabels[i][0], mSizesLabels[i][1]);
            etiqueta.setLocation(mPosicionesLabels[i][0],mPosicionesLabels[i][1]);
            panel.add(etiqueta);
            etiquetas.add(etiqueta);
            panel.validate();
            panel.updateUI();
        }
    }
    public void crearBotones(JFrame frm, Timer tmr){
        int[][]mPosicionesBtn = {{27, 257}, {27, 312}};
        int[][]mSizesBtn = {{103, 26}, {103, 26}};
        String[][]infoBtn = {{"jbtnJugar", "Jugar"}, {"jbtnSalir", "Salir"}}; 
        for (int i = 0; i < mPosicionesBtn.length; i++) {
            boton = new JButton();
            boton.setName(infoBtn[i][0]);
            boton.setText(infoBtn[i][1]);
            boton.setBackground(Color.BLACK);
            boton.setForeground(Color.white);
            boton.setOpaque(true);
            boton.setVisible(true);
            boton.setSize(mSizesBtn[i][0], mSizesBtn[i][1]);
            boton.setLocation(mPosicionesBtn[i][0],mPosicionesBtn[i][1]);
            panel.add(boton);
            botones.add(boton);
            panel.validate();
            panel.updateUI();
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    iniciarPartida(e, frm, tmr);
                }
            });
        }
    }
    public void iniciarPartida(ActionEvent e, JFrame frm, Timer tmr){
        JButton btn = (JButton)e.getSource();
        switch (btn.getName()) {
            case "jbtnJugar":
                limpiarObjetos();
                generarOrdenImg();
                inciar = true;
                tmr.start();
            break;
            case "jbtnSalir":
                frm.dispose();
            break;
        }
    }
    public void crearTarjetas(JFrame frm, Timer tmr){
        int[][]mPosicionesBtn = {{200, 180}, {200, 287}, {200, 394}, {200, 501}, {307, 180}, {307, 287}, {307, 394}, {307, 501}};
        for (int i = 0; i < mPosicionesBtn.length; i++) {
            boton = new JButton();
            boton.setName("jbtnTarjeta"+i);
            boton.setBackground(Color.BLACK);
            boton.setForeground(Color.white);
            boton.setOpaque(true);
            boton.setVisible(true);
            boton.setSize(72, 81);
            boton.setLocation(mPosicionesBtn[i][1],mPosicionesBtn[i][0]);
            panel.add(boton);
            tarjetas.add(boton);
            panel.validate();
            panel.updateUI();
            boton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (contSegundos == 0 & inciar) {
                    voltearTarjeta(e, frm, tmr);
                }
            }
        });
        }
        
    }
    public void voltearTarjeta(ActionEvent e, JFrame frm, Timer tmr){
        JButton btn = (JButton)e.getSource();
        if((numerosRandom[Integer.valueOf(btn.getName().substring(btn.getName().length() - 1))][1]) == 0){
            if (numTarjetasVolteadas < 2) {
                mostrarTarjetas(frm, btn, imagenesMemorama[numerosRandom[Integer.valueOf(btn.getName().substring(btn.getName().length() - 1))][0]]);
                tarjetasVolteadas[numTarjetasVolteadas] = Integer.valueOf(btn.getName().substring(btn.getName().length() - 1));
                numTarjetasVolteadas++;
            }
            if (numTarjetasVolteadas == 2) {
                if((numerosRandom[tarjetasVolteadas[0]][1]) == 0 & (numerosRandom[tarjetasVolteadas[1]][1]) == 0){
                    validarTarjetas(frm, tmr);
                    numTarjetasVolteadas = 0;
                }
            }
        }
        
    }
    public void validarTarjetas(JFrame frm, Timer tmr){
        if (numerosRandom[tarjetasVolteadas[0]][0] == numerosRandom[tarjetasVolteadas[1]][0]) {
            numParesCorrectos++;
            numerosRandom[tarjetasVolteadas[0]][1] = 1;
            numerosRandom[tarjetasVolteadas[1]][1] = 1;
        }else{
            contSegundos = 1;
            numParesFallos++;
        }
        
    }
    public void mostrarTarjetas(JFrame frm, JButton imagenLogo, String urlImag) {
        URL urlImagen = frm.getClass().getResource(urlImag);
        ImageIcon imgL = new ImageIcon(urlImagen);
        Icon imagen = new ImageIcon(imgL.getImage().getScaledInstance(imagenLogo.getWidth(), imagenLogo.getHeight(), Image.SCALE_DEFAULT));
        imagenLogo.setIcon(imagen);
        frm.repaint();
    }
    public void generarOrdenImg(){
        for (int i = 0; i < numerosRandom.length; i++) {
            numerosRandom[i][0] = -1;
            numerosRandom[i][1] = 0; // Mientras no se volteen
        }
        int controlRep = 0;
        for (int i = 0; i < numerosRandom.length; i++) { 
            int random = (int)(Math.random()*4);
            for (int j = 0; j < numerosRandom.length; j++) {
                if (random == numerosRandom[j][0]) {
                    controlRep++;
                }
            }
            if (controlRep < 2) {
                numerosRandom[i][0] = random;
            }else{
                if (i==numerosRandom.length-1 & numerosRandom[i][0]!= -1) {
                    i++;
                }else{
                    i--;
                }
            }
            controlRep = 0;
        }
    }
    public void limpiarObjetos(){
        inciar = false;
        numerosRandom = new int[8][2];
        tarjetasVolteadas = new int[2];
        numParesCorrectos = 0;
        numParesFallos = 0;
        numTarjetasVolteadas = 0;
        contSegundos = 0;
    }
}
