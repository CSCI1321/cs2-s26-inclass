package cs2.cardgames;

public  class Hand {
  //Field
  private Deck hand;
  //Constructor
  public Hand() {
    hand = new Deck();
    //hand = Deck.emptyDeck();
  }
  //Methods
  public void add(Card c) {
    hand.add(c);
  }
  public int getTotal() {
    int score = 0;
    int numAces = 0;
    for(int i=0; i<hand.size(); i++) {
      if(hand.getCard(i).isFaceCard()) {
        score += 10;
      } else {
        score += hand.getCard(i).getRank();
        if(hand.getCard(i).getRank() == 1) {
          numAces += 1;
        }
      }
    }
    if(numAces > 0 && score + 10 < 21) {
      score += 10;
    }
    return score;
  }
  public boolean busted() {
    if(getTotal() > 21) return true;
    else return false;
  }

  public String toString() {
    return hand.toString();
  }
  public String dealerToString() {
    String result = "[";
    result += hand.getCard(0) + ", ??]";
    return result;
  }
}