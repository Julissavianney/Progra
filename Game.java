package rpg;

import rpg.Inventory.Inventory;
import rpg.Inventory.items.*;
import rpg.entities.Player;
import rpg.entities.enemy.Enemy;
import rpg.entities.enemy.goblins.RookieGoblin;
import rpg.entities.enemy.slimes.BasicSlime;
import rpg.gui.GUIForm;
import rpg.gui.labels.GoldLabel;
import rpg.gui.labels.NameLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game {

    private Player player;
    private Enemy enemy;
    private Inventory inventory;
    private GoldLabel goldLabel;
    private NameLabel nameLabel;
    private JPanel topPanel;
    private JPanel bottomPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.startGame();
            new GUIForm(game);
        });
    }

    public Game() {
        this.player = new Player("Odin");
        int enemyType = new Random().nextInt(3) + 1;
        this.enemy = switch (enemyType) {
            case 1 -> new RookieGoblin();
            case 2 -> new BasicSlime("Basic Slime");
            default -> new Enemy("Otro enemigo:");
        };
        this.inventory = new Inventory();
        createUIComponents(); // Inicializa los componentes de la interfaz
    }

    public void startGame() {
        manageGame();
        while (player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }

        if (player.isAlive()) {
            System.out.println(player.getName() + " GANO el mas perro");
        } else {
            System.out.println(enemy.getName() + " Ganooooo ");
        }
    }

    private void manageGame() {
        // Aquí puedes agregar lógica para manejar el juego
    }

    public void saveGame() {
        System.out.println("Juego guardado.");
    }

    public void exitGame() {
        System.exit(0);
    }

    public void openInventory() {
        System.out.println("Inventario abierto.");
    }

    public void showStats() {
        System.out.println("Mostrando estadísticas del jugador.");
    }

    private void createUIComponents() {
        goldLabel = new GoldLabel();
        nameLabel = new NameLabel("{Odin} LVL. 1"); // Nombre de personaje de ejemplo
        topPanel = new JPanel();
        bottomPanel = new JPanel();

        // Configura el layout de los paneles
        topPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new FlowLayout());

        topPanel.add(nameLabel);
        bottomPanel.add(goldLabel);
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }
}