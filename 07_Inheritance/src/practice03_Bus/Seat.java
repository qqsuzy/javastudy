package practice03_Bus;

public class Seat {

  // filed
  private Person person;
  
  public void fill(Person person) {
    this.person = person;
  }
  
  public void whoami() {
    person.whoami();
  }
  
}
