package GameCore.Enemies;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyFactory {
    public EnemyFactory() {

    }

    public Orc makeOrc() {
        Random rand = new Random();
        List<String> orcNames = Arrays.asList("Kabugbu","Zudagog","Batul","Nash","Ewkbanok","Rurigig");
        return new Orc(rand.nextInt(50),rand.nextInt(50),orcNames.get(rand.nextInt(orcNames.size())),rand.nextInt(9)+1);
    }

    public Ninja makeNinja() {
        Random rand = new Random();
        List<String> orcNames = Arrays.asList("Takumotokashitemo","Zushidotomo","Kizushika","Arichikatotezufu","Lukitakinoku","Tokitozuka");
        return new Ninja(rand.nextInt(50),rand.nextInt(50),orcNames.get(rand.nextInt(orcNames.size())),rand.nextInt(4)+1);
    }

    public Goblin makeGoblin() {
        Random rand = new Random();
        List<String> orcNames = Arrays.asList("Stryggiact","Tolkoit","Proikx","Ax","Aardilk","Han");
        return new Goblin(rand.nextInt(50),rand.nextInt(50),orcNames.get(rand.nextInt(orcNames.size())),rand.nextInt(2)+1);
    }

    public Thug makeThug() {
        Random rand = new Random();
        List<String> orcNames = Arrays.asList("John, the drug addict","Sam, the drug dealer","Ahmed, the terrorrist","Giovani, the godfather","Daniel, the nuclear warlord","Peter, the autistic NeoNazi");
        return new Thug(rand.nextInt(50),rand.nextInt(50),orcNames.get(rand.nextInt(orcNames.size())),rand.nextInt(2)+1);
    }
}
