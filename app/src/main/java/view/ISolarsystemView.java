package view;

/**
 * Interface for SolarSystemView
 */
public interface ISolarsystemView {
  
  static enum Menu {
    List,
    Add,
    Inspect,
    Quit
  }

  static enum SolarSystemMenu {
    View,
    Add,
    Delete,
    Back,
  }

  <T extends model.SolarSystem> void displaySolarSystems(Iterable<T> solarSystems);

  model.SolarSystem createSolarSystem();

  /**
   * Select a solarsystem from a list. 
   *
   * @param <T> Member.
   * @param list List of member.
   * @return Member.
   */
  <T extends model.SolarSystem> T selectSolarSystem(Iterable<T> list);


  <T extends model.SolarSystem>  void displaySolarSystemDetails(T solarSystem);

  <T extends model.Planet>  void displayPlanetAndMoons(T planet);

  model.Planet createPlanet();

  model.Moon createMoon();

  String deleteMember();

  void showMessage(String message);
}
