/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avanceestructura;

/**
 *
 * @author User
 */
public class Pokemon {
    private String nombre;
    private String tipo;
    private int hp;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;

    public Pokemon(String nombre, String tipo, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHP() {
        return hp;
    }

    public void atacar(Pokemon objetivo, int danio) {
        objetivo.recibirDanio(danio);
    }

    public void recibirDanio(int danio) {
        hp -= danio;
        if (hp < 0) {
            hp = 0;
        }
    }

    int getAtaque() {
        return 0;
    }
}

