package UStore;

public class RewardsItemGenerator {
    RewardsItemFactory rewardsItemFactory = new RewardsItemFactory();
    public RewardsItem generateRewardsItem(String itemType){
        RewardsItem rewardsItem= (RewardsItem) rewardsItemFactory.getItem(itemType);
        //TODO: get customer's points earned
        float customerPoints = 12;
        rewardsItem.redeemItem((int)customerPoints);
        return rewardsItem;

    }


}