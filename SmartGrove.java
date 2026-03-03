/*
 Progam Name: BSc Computing with foundation
 Module Title: SWE4305 Object Oriented Programming
 Assessment Title: Smart Grove Management System (Phase 1)
 Name/Surname: Panagiotis Margetis
 Marking Tutor: Mr. Konstantinos Tsakonas
 Date of submission: 3/3/2026
*/

public class SmartGrove {

// Main

    public static void main(String[] args) {

        System.out.println("===== SMART GROVE SYSTEM =====");

        OliveTree tree1 = new OliveTree(1, "Kalamata", 2015);
        OliveTree tree2 = new OliveTree(2, "Koroneiki", 2018);
        OliveTree tree3 = new OliveTree(3, "Sparti", 2012);

        printTree(tree1);
        printTree(tree2);
        printTree(tree3);
    }

    public static void printTree(OliveTree tree) {

        System.out.println("Tree ID: " + tree.getId());
        System.out.println("Olive Type: " + tree.getOliveType());
        System.out.println("Scientific Name: " + tree.getScientificName());
        System.out.println("Tree Age: " + tree.getAge());
        System.out.println("Max Age: " + tree.getMaxAge());

        System.out.println("Fruit Production: " + tree.produceFruit());

        double olives = tree.harvestOlives();
        System.out.println("Olives Harvested: " + olives + " kg");

        double oil = tree.calculateOilYield();
        System.out.println("Oil Produced: " + oil + " liters");

        System.out.println("Is Gnarled: " + tree.isGnarled());
    }
}

// Tree class (Superclass)

class Tree {

    // Identity
    private int id;
    private int plantYear;

    // Physical Dimensions
    private double height;
    private double trunkDiameter;
    private double canopyRadius;
    private double rootDepth;

    // Biological Identity
    private String species;
    private String scientificName;
    private boolean isDeciduous;
    private int maxAge;

    // State and Health
    private double healthStatus;
    private boolean isFlowering;
    private double foliageDensity;
    private double waterLevel;

    public Tree(int id, String species, String scientificName,
                boolean isDeciduous, int plantYear, int maxAge) {

        this.id = id;
        this.species = species;
        this.scientificName = scientificName;
        this.isDeciduous = isDeciduous;
        this.plantYear = plantYear;
        this.maxAge = maxAge;

        this.healthStatus = 1.0;
        this.isFlowering = true;
        this.foliageDensity = 1.0;
        this.waterLevel = 1.0;
    }

    public int getAge() {
        return 2026 - plantYear;
    }

    public String produceFruit() {

        if (getAge() > 3 && isFlowering && healthStatus > 0.5) {
            return "Fruit";
        } else {
            return "No fruit";
        }
    }

    public double harvestWood() {

        double woodAmount = trunkDiameter * 10;
        healthStatus = 0.0;
        return woodAmount;
    }

    public int getId() {
        return id;
    }

    public String getScientificName() {
        return scientificName;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public double getHealthStatus() {
        return healthStatus;
    }
}

// OliveTree class (Subclass)

class OliveTree extends Tree {

    private String oliveType;
    private double yieldAmount;
    private double oilContent;
    private boolean isGnarled;
    private boolean isAlternateBearing;

    public OliveTree(int id, String oliveType, int plantYear) {

        super(id, "Olive Tree", "Olea europaea",
                false, plantYear, 500);

        this.oliveType = oliveType;
        this.yieldAmount = 0;
        this.isGnarled = false;
        this.isAlternateBearing = false;

        if (oliveType.equals("Kalamata")) {
            oilContent = 0.20;
        } else if (oliveType.equals("Koroneiki")) {
            oilContent = 0.25;
        } else if (oliveType.equals("Sparti")) {
            oilContent = 0.22;
        } else {
            oilContent = 0.18;
        }
    }

    public String produceFruit() {

        if (getAge() > 3 && getHealthStatus() > 0.5) {
            return "Olives";
        } else {
            return "No olives";
        }
    }

    public double harvestOlives() {

        if (getAge() > 3 && getHealthStatus() > 0.5) {

            if (isAlternateBearing == false) {
                yieldAmount = 40;
                isAlternateBearing = true;
            } else {
                yieldAmount = 20;
                isAlternateBearing = false;
            }

            return yieldAmount;
        }

        return 0;
    }

    public double calculateOilYield() {
        return yieldAmount * oilContent;
    }

    public String getOliveType() {
        return oliveType;
    }

    public boolean isGnarled() {
        return isGnarled;
    }
}




