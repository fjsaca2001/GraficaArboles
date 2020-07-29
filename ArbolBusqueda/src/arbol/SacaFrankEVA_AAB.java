package arbol;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class SacaFrankEVA_AAB extends JFrame {
    // Clase para crear la estructura del arbol
    public class Nodo {

        private int dato;
        private Nodo nodoIzq, nodoDer;
        // Constructor de la clase
        public Nodo(int dato, Nodo nodoIzq, Nodo nodoDer) {
            this.dato = dato;
            this.nodoIzq = nodoIzq;
            this.nodoDer = nodoDer;
        }
        // Metodos get y set para los nodos 
        public int getDato() {
            return dato;
        }

        public void setDato(int dato) {
            this.dato = dato;
        }
        
        public Nodo getNodoIzq() {
            return nodoIzq;
        }

        public void setNodoIzq(Nodo nodoIzq) {
            this.nodoIzq = nodoIzq;
        }

        public Nodo getNodoDer() {
            return nodoDer;
        }

        public void setNodoDer(Nodo nodoDer) {
            this.nodoDer = nodoDer;
        }

    }

    // Clase para llamar a los metodos de agregar
    public class PruebaArbol {

        private Nodo raiz;
        // Constructor de la clase
        public PruebaArbol() {
            raiz = null;
        }
        // Metodo que llama al metodo insertar para agregar el valor al arbol
        public boolean agregar(int dato) {
            // nodo auxiliar
            Nodo nuevo = new Nodo(dato, null, null);
            // Llamada al metodo
            insertar(nuevo, raiz);
            return true;
        }

        //insertar un dato al arbol
        public void insertar(Nodo nuevo, Nodo aux) {
            // En caso de ser el primer dato en entrar
            if (this.raiz == null) {
                raiz = nuevo;
            // Sino pasa a validar si se dirije a la Izq o Der
            } else {
                if (nuevo.getDato() <= aux.getDato()) {
                    if (aux.getNodoIzq() == null) {
                        aux.setNodoIzq(nuevo);
                    } else {
                        insertar(nuevo, aux.getNodoIzq());
                    }
                } else {
                    if (aux.getNodoDer() == null) {
                        aux.setNodoDer(nuevo);
                    } else {
                        insertar(nuevo, aux.getNodoDer());
                    }
                }
            }

        }
        // MEtodos get y set para poder obtener la raiz
        public Nodo getRaiz() {
            return raiz;
        }

        public void setRaiz(Nodo raiz) {
            this.raiz = raiz;
        }

        //metodo que llama a PreOrden
        public ArrayList preOrden() {
            ArrayList preO = new ArrayList();
            preorden(raiz, preO);
            return preO;
        }

        //recorrido recursivo y almacenado del resultado
        public void preorden(Nodo aux, ArrayList result) {
            if (aux != null) {
                result.add(aux.getDato());
                preorden(aux.getNodoIzq(), result);
                preorden(aux.getNodoDer(), result);
            }
        }

        //metodo que llama a Inorden
        public ArrayList inOrden() {
            ArrayList inO = new ArrayList();
            inorden(raiz, inO);
            return inO;
        }

        //recorrido recursivo y almacenado del resultado
        public void inorden(Nodo aux, ArrayList result) {
            if (aux != null) {
                inorden(aux.getNodoIzq(), result);
                result.add(aux.getDato());
                inorden(aux.getNodoDer(), result);
            }
        }

        //metodo que llama a PostOrden
        public ArrayList postOrden() {
            ArrayList postO = new ArrayList();
            postorden(raiz, postO);
            return postO;
        }

        //recorrido recursivo y almacenado del resultado
        public void postorden(Nodo aux, ArrayList result) {
            if (aux != null) {
                postorden(aux.getNodoIzq(), result);
                postorden(aux.getNodoDer(), result);
                result.add(aux.getDato());
            }
        }
        // Metodo para crear un panel para el grafico
        public JPanel getdibujo() {
            // Llamada al metodo 
            return new ArbolGrafico(this);
        }
    }
    // Creacion de un onjeto para proceder a graficar
    private GraficaArbol gArbol = new GraficaArbol();
    // Propiedades del panel principal
    public SacaFrankEVA_AAB() {
        initComponents();
        this.setLocationRelativeTo(null);//Siempre al centro
        this.inicializar(false); // Llamada al metodo para el rrecorrido
    }

    // Metodo para que funcionen los botones de recorrido si existen datos
    private void inicializar(boolean bandera) {
        this.jButtonInO.setEnabled(bandera);
        this.jButtonPostO.setEnabled(bandera);
        this.jButtonPreO.setEnabled(bandera);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jFrameInt = new javax.swing.JInternalFrame();
        txtdato = new javax.swing.JTextField();
        jButtonInsertar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaResultados = new javax.swing.JTextArea();
        jButtonPostO = new javax.swing.JButton();
        jButtonPreO = new javax.swing.JButton();
        jButtonInO = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.pink);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(java.awt.Color.pink);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Panel de Pruebas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N
        jPanel2.setOpaque(false);

        jDesktopPane1.setBackground(java.awt.Color.pink);
        jDesktopPane1.setOpaque(false);

        jFrameInt.setBackground(java.awt.Color.pink);
        jFrameInt.setEnabled(false);
        jFrameInt.setFocusCycleRoot(false);
        jFrameInt.setVisible(true);

        javax.swing.GroupLayout jFrameIntLayout = new javax.swing.GroupLayout(jFrameInt.getContentPane());
        jFrameInt.getContentPane().setLayout(jFrameIntLayout);
        jFrameIntLayout.setHorizontalGroup(
            jFrameIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        jFrameIntLayout.setVerticalGroup(
            jFrameIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jDesktopPane1.add(jFrameInt);
        jFrameInt.setBounds(-20, -30, 630, 390);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, -1, 356));
        jPanel2.getAccessibleContext().setAccessibleName("");

        txtdato.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtdato.setToolTipText("");
        txtdato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdatoActionPerformed(evt);
            }
        });
        getContentPane().add(txtdato, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 45, 248, 23));

        jButtonInsertar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonInsertar.setForeground(java.awt.Color.red);
        jButtonInsertar.setText("Insertar");
        jButtonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInsertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 74, 248, 30));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(207, 77, 77));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese un número");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 12, 248, 27));

        lblMensaje.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblMensaje.setForeground(java.awt.Color.red);
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 110, 230, 66));

        jTextAreaResultados.setEditable(false);
        jTextAreaResultados.setColumns(20);
        jTextAreaResultados.setForeground(java.awt.Color.red);
        jTextAreaResultados.setRows(5);
        jScrollPane2.setViewportView(jTextAreaResultados);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 227, 270, 105));

        jButtonPostO.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonPostO.setForeground(java.awt.Color.red);
        jButtonPostO.setText("PostOrden");
        jButtonPostO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPostOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPostO, new org.netbeans.lib.awtextra.AbsoluteConstraints(794, 182, -1, 33));

        jButtonPreO.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonPreO.setForeground(java.awt.Color.red);
        jButtonPreO.setText("PreOrden");
        jButtonPreO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPreO, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 182, -1, 33));

        jButtonInO.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButtonInO.setForeground(java.awt.Color.red);
        jButtonInO.setText("InOrden");
        jButtonInO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInOActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonInO, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 182, 82, 33));

        jButtonSalir.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        jButtonSalir.setForeground(java.awt.Color.red);
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 338, 96, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png"))); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 320));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png"))); // NOI18N
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 470, 300));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png"))); // NOI18N
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 250, 500, 130));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo.png"))); // NOI18N
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 480, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Metodo para el boton insertar si no funciona presenta un texto y vueve a ingresar
    private void jButtonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertarActionPerformed
        // Try-catch que funcionara en caso de que no se ingrese un numero
        try {
            // Obtencion del dato ingresado
            int valor = Integer.parseInt(txtdato.getText());
            // Insertar el dato
            if (this.gArbol.insertar(valor)) {
                // Mensaje señalando que se ah ingresado
                lblMensaje.setText("El valor " + valor + ". Se agregó al Arbol");
                // Llamada al metodo para que funcionen los botones
                this.inicializar(true);
                txtdato.setText("");// Borrado del texto
                complementos();
            }
        } catch (Exception ex) {
            txtdato.setText("");// Borrado del texto
            lblMensaje.setText("ALERTA: Vuelva a intentar..");// Si no es numero
        }
    }//GEN-LAST:event_jButtonInsertarActionPerformed

    private void txtdatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdatoActionPerformed
    }//GEN-LAST:event_txtdatoActionPerformed

    private void jButtonPostOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPostOActionPerformed
        // boton postOrden 
        String recorrido = null;
        recorrido = this.gArbol.postOrden();
        this.jTextAreaResultados.setText("");
        // Presentar los datos del recorrido
        this.jTextAreaResultados.setText(recorrido);
    }//GEN-LAST:event_jButtonPostOActionPerformed

    private void jButtonPreOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreOActionPerformed
        // boton preOrden
        String recorrido = null;
        recorrido = this.gArbol.preOrden();
        this.jTextAreaResultados.setText("");
        // Presentar los datos del recorrido
        this.jTextAreaResultados.setText(recorrido);
    }//GEN-LAST:event_jButtonPreOActionPerformed

    private void jButtonInOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInOActionPerformed
        // boton inOrden
        String recorrido = null;
        recorrido = this.gArbol.inOrden();
        this.jTextAreaResultados.setText("");
        // Presentar los datos del recorrido
        this.jTextAreaResultados.setText(recorrido);
    }//GEN-LAST:event_jButtonInOActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        //Cerrar ventana
        dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    public void complementos() {
        // Actualizar los cambios del grafico
        this.repintarArbol();
    }
    // Agregar graficamente el nuevo valor ingresado
    private void repintarArbol() {
        // Propiedades del panel
        this.jDesktopPane1.removeAll();
        Rectangle tamaño = this.jFrameInt.getBounds();
        this.jFrameInt = null;
        this.jFrameInt = new JInternalFrame("Arbol", true);
        this.jDesktopPane1.add(this.jFrameInt, JLayeredPane.DEFAULT_LAYER);
        this.jFrameInt.setVisible(true);
        this.jFrameInt.setBounds(tamaño);
        this.jFrameInt.setEnabled(false);
        this.jFrameInt.add(this.gArbol.getDibujo(), BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SacaFrankEVA_AAB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SacaFrankEVA_AAB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SacaFrankEVA_AAB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SacaFrankEVA_AAB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SacaFrankEVA_AAB().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInO;
    private javax.swing.JButton jButtonInsertar;
    private javax.swing.JButton jButtonPostO;
    private javax.swing.JButton jButtonPreO;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JInternalFrame jFrameInt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaResultados;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtdato;
    // End of variables declaration//GEN-END:variables
    // Clase previa la graficacion
    public class GraficaArbol {
        //Creacion de un objeto PruebaArbol
        PruebaArbol arbol = new PruebaArbol();
        //Constructor de la clase
        public GraficaArbol() {
        }
        //Metodo para insertar
        public boolean insertar(Integer dato) {
            return (this.arbol.agregar(dato));
        }
        //Metodo para guardar el recorrido
        public String preOrden() {
            ArrayList it = this.arbol.preOrden();
            return (recorrido(it, "PreOrden: "));
        }
        //Metodo para guardar el recorrido
        public String inOrden() {
            ArrayList it = this.arbol.inOrden();
            return (recorrido(it, "InOrden: "));
        }
        //Metodo para guardar el recorrido
        public String postOrden() {
            ArrayList it = this.arbol.postOrden();
            return (recorrido(it, "PosOrden: "));
        }
        // Concatenacion del resultado del recorrido
        private String recorrido(ArrayList orden, String result) {
            int i = 0;
            String res = result + "\n";
            //Ciclo para que recorra toda la lista de valores
            while (i < orden.size()) {
                res += orden.get(i).toString() + "-";
                i++;
            }
            return (res);
        }

        public JPanel getDibujo() {
            return this.arbol.getdibujo();
        }
    }
    // Graficacion del arbol
    public class ArbolGrafico extends JPanel {
        //Variables locales necesarias para la creacion del grafico
        private PruebaArbol arbol;
        private HashMap posicion = null;
        private HashMap tamanioArbol = null;
        private boolean lleno = true;
        private int padreHijo = 20, hijos = 30;
        private Dimension dimension = new Dimension(0, 0);
        private FontMetrics metrica = null;

        /* Constructor de la clase que personaliza la ventana y permite llamar 
        al metodo repaint() para actualizar el grafico cuando se ingrese un 
        nuevo valor*/
        public ArbolGrafico(PruebaArbol arbol) {
            this.arbol = arbol;
            this.setBackground(Color.DARK_GRAY);
            this.setForeground(Color.RED);
            posicion = new HashMap();
            tamanioArbol = new HashMap();
            lleno = true;
            repaint();
        }

        /*Calcular las posiciones de los subárboles y sus hijos para saber 
        su posicion en la que se graficara*/
        private void calcularPosiciones() {
            posicion.clear();
            tamanioArbol.clear();
            Nodo aux = this.arbol.getRaiz();
            if (aux != null) {
                calcularTamanio(aux);
                calcularPosicion(aux, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
            }
        }

        /* Calcula el tamaño de los subárboles y se agrega al HashMap*/
        private Dimension calcularTamanio(Nodo nodo) {
            if (nodo == null) return new Dimension(0, 0);
            
            Dimension isqD = calcularTamanio(nodo.getNodoIzq());
            Dimension derD = calcularTamanio(nodo.getNodoDer());
            int alto = metrica.getHeight() + padreHijo + Math.max(isqD.height, derD.height);
            int ancho = isqD.width + hijos + derD.width;
            Dimension dim = new Dimension(ancho, alto);
            tamanioArbol.put(nodo, dim);
            return dim;
        }

        //Se calcula la ubicación de cada nodo y agrega
        private void calcularPosicion(Nodo nodo, int izq, int der, int total) {
            if (nodo == null) return;
            
            Dimension izqD = (Dimension) tamanioArbol.get(nodo.getNodoIzq());
            izqD = (izqD == null) ? dimension : izqD;
            Dimension derD = (Dimension) tamanioArbol.get(nodo.getNodoDer());
            derD = (derD == null) ? dimension : derD;
            int centro = 0;
            centro = (der != Integer.MAX_VALUE) ? der - derD.width - hijos / 2 : centro;
            centro = (izq != Integer.MAX_VALUE) ? izq + izqD.width + hijos / 2 : centro;

            int an = metrica.stringWidth(nodo.getDato() + "");
            posicion.put(nodo, new Rectangle(centro - an / 2 - 3, total, an + 6, metrica.getHeight()));

            calcularPosicion(nodo.getNodoIzq(), Integer.MAX_VALUE, centro - hijos / 2, total + metrica.getHeight() + padreHijo);
            calcularPosicion(nodo.getNodoDer(), centro + hijos / 2, Integer.MAX_VALUE, total + metrica.getHeight() + padreHijo);
        }

        //Dibuja el árbol gracias a las ubicaciones que obtuvimos en el metodo anterior
        private void dibujarArbol(Graphics2D grafic, Nodo nod, int pX, int pY, int alt) {
            if (nod == null) return;
            //Agrega el valor sobre on grafico Rectangle
            Rectangle marco = (Rectangle) posicion.get(nod);
            grafic.draw(marco);
            grafic.drawString(nod.getDato() + "", marco.x + 3, marco.y + alt);

            if (pX != Integer.MAX_VALUE) {
                grafic.drawLine(pX, pY, (int) (marco.x + marco.width / 2), marco.y);
            }

            dibujarArbol(grafic, nod.getNodoIzq(), (int) (marco.x + marco.width / 2), marco.y + marco.height, alt);
            dibujarArbol(grafic, nod.getNodoDer(), (int) (marco.x + marco.width / 2), marco.y + marco.height, alt);

        }

        /**
         * Sobreescribe el metodo paint y se encarga de pintar todo el árbol.
         */
        @Override
        public void paint(Graphics grafico) {
            super.paint(grafico);
            metrica = grafico.getFontMetrics();

            if (lleno) {
                calcularPosiciones();
                lleno = false;
            }

            Graphics2D gAux = (Graphics2D) grafico;
            gAux.translate(getWidth() / 2, padreHijo);
            dibujarArbol(gAux, this.arbol.getRaiz(), Integer.MAX_VALUE, Integer.MAX_VALUE, metrica.getLeading() + metrica.getAscent());
            metrica = null;
        }
    }
}
