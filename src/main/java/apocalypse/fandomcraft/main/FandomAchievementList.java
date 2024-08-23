package apocalypse.fandomcraft.main;

import net.minecraftforge.common.*;
import net.minecraft.stats.*;
import java.util.*;
import apocalypse.fandomcraft.horror.*;
import net.minecraft.init.*;

public class FandomAchievementList extends AchievementPage
{
    public static int minDisplayColumn;
    public static int minDisplayRow;
    public static int maxDisplayColumn;
    public static int maxDisplayRow;
    public static List achievementList;
    public static Achievement rupee;
    public static Achievement FCdreamSword;
    public static Achievement ring;
    public static Achievement coin;
    public static Achievement otherworld;
    public static Achievement trueFourSword;
    public static Achievement FCdarkHeart;
    public static Achievement FCkingdomKey;
    public static Achievement goldenFeather;
    public static Achievement FCjungleKing;
    public static Achievement chaos;
    public static Achievement hylianHero;
    public static Achievement masterSword;
    public static Achievement FCultima;
    public static Achievement ragnarok;
    public static Achievement masterQuest;
    public static Achievement bombskit;
    public static Achievement dragon2;
    public static Achievement armos;
    public static Achievement murder;
    
    public FandomAchievementList() {
        super("FandomCraft", new Achievement[] { FandomAchievementList.rupee, FandomAchievementList.FCdarkHeart, FandomAchievementList.goldenFeather, FandomAchievementList.FCkingdomKey, FandomAchievementList.FCjungleKing, FandomAchievementList.trueFourSword, FandomAchievementList.masterSword, FandomAchievementList.FCultima, FandomAchievementList.ragnarok, FandomAchievementList.chaos, FandomAchievementList.ring, FandomAchievementList.FCdreamSword, FandomAchievementList.coin, FandomAchievementList.bombskit, FandomAchievementList.armos, FandomAchievementList.masterQuest, FandomAchievementList.dragon2, FandomAchievementList.murder, FandomAchievementList.otherworld });
    }
    
    public static void init() {
    }
    
    static {
        FandomAchievementList.achievementList = new ArrayList();
        FandomAchievementList.rupee = new Achievement("achievement.rupee", "rupee", 0, 0, Main.rupeeGreen, (Achievement)null).initIndependentStat().registerStat();
        FandomAchievementList.FCdreamSword = new Achievement("achievement.FCdreamSword", "FCdreamSword", 2, 0, Main.dreamSword, (Achievement)null).initIndependentStat().registerStat();
        FandomAchievementList.ring = new Achievement("achievement.ring", "ring", -2, 0, Main.ring, (Achievement)null).initIndependentStat().registerStat();
        FandomAchievementList.coin = new Achievement("achievement.coin", "coin", -4, 0, Main.coin, (Achievement)null).initIndependentStat().registerStat();
        FandomAchievementList.otherworld = new Achievement("achievement.otherworld", "otherworld", -6, 0, HorrorReg.bloodBlock, (Achievement)null).initIndependentStat().registerStat();
        FandomAchievementList.trueFourSword = new Achievement("achievement.trueFourSword", "trueFourSword", 0, 2, Main.fourSword_2, FandomAchievementList.rupee).registerStat();
        FandomAchievementList.FCdarkHeart = new Achievement("achievement.FCdarkHeart", "FCdarkHeart", 2, 2, Main.darkHeart, FandomAchievementList.FCdreamSword).initIndependentStat().registerStat();
        FandomAchievementList.FCkingdomKey = new Achievement("achievement.FCkingdomKey", "FCkingdomKey", 2, 4, Main.keyKingdom, FandomAchievementList.FCdarkHeart).initIndependentStat().registerStat();
        FandomAchievementList.goldenFeather = new Achievement("achievement.goldenFeather", "goldenFeather", 0, 4, Main.goldenFeather, FandomAchievementList.trueFourSword).initIndependentStat().registerStat();
        FandomAchievementList.FCjungleKing = new Achievement("achievement.FCjungleKing", "FCjungleKing", 2, 6, Main.jungleKing, FandomAchievementList.FCkingdomKey).initIndependentStat().registerStat();
        FandomAchievementList.chaos = new Achievement("achievement.chaos", "chaos", -2, 6, Main.masterEmerald, FandomAchievementList.ring).initIndependentStat().registerStat();
        FandomAchievementList.hylianHero = new Achievement("achievement.hylianHero", "hylianHero", -2, 6, Main.dinsPearl, FandomAchievementList.goldenFeather).initIndependentStat().registerStat();
        FandomAchievementList.masterSword = new Achievement("achievement.masterSword", "masterSword", 0, 8, Main.Triforce, FandomAchievementList.goldenFeather).setSpecial().initIndependentStat().registerStat();
        FandomAchievementList.FCultima = new Achievement("achievement.FCultima", "FCultima", 2, 10, Main.ultima, FandomAchievementList.FCkingdomKey).setSpecial().initIndependentStat().registerStat();
        FandomAchievementList.ragnarok = new Achievement("achievement.ragnarok", "ragnarok", 4, 10, Main.ragnarok, FandomAchievementList.rupee).setSpecial().initIndependentStat().registerStat();
        FandomAchievementList.masterQuest = new Achievement("achievement.masterQuest", "masterQuest", 0, 10, Main.gannonSword, FandomAchievementList.masterSword).registerStat().setSpecial();
        FandomAchievementList.bombskit = new Achievement("achievement.bombskit", "bombskit", 0, -2, Main.bomb, FandomAchievementList.rupee).initIndependentStat().registerStat();
        FandomAchievementList.dragon2 = new Achievement("achievement.dragon2", "dragon2", 0, -4, Blocks.dragon_egg, FandomAchievementList.rupee).initIndependentStat().registerStat();
        FandomAchievementList.armos = new Achievement("achievement.armos", "armos", 0, -3, Main.bomb, FandomAchievementList.rupee).initIndependentStat().registerStat().setSpecial();
        FandomAchievementList.murder = new Achievement("achievement.murder", "murder", 0, -1, Main.bullet, FandomAchievementList.otherworld).initIndependentStat().registerStat().setSpecial();
    }
}
