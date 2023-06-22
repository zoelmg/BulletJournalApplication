[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)

# 3500 PA05 Project Repo

[PASSWORD FOR BUJO]
password: i love javadocs
(all lowercase)

[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)

[NOTES ABOUT GIT BUILD & MISSING MODULE-INFO.JAVA FILE]
- The git build is not building because of the JavaFX GUI Testing, however, we have spoken to
  Dr. Fontenot about this, and he said it was okay. We also have getters in our controller for
  our dialogs and asked if it was okay for the sake of JavaFX GUI testing and for future extension
  purposes, and he also said it was okay in-person. Dr. Fontenot pulled from our repository and made sure
  that the GUI testing worked on his end as well. Screenshot could be found in root directory named as
  "Message_With_Professor.png"

- Jackson Binding was not working with Module-Info.java, which is why we deleted it. The terminal
  may produce a message "loading from unnamed module" when running the program, but we also confirmed with
  Dr.Fontenot that it is okay.

  [BUJO PITCH]
Welcome to your very own, easy to use, digital Bujo Journal! 
With many detailed features to edit week names, create new events and tasks, as well as write in your own notes and 
quotes, this product will serve as a handy organizational tool for any student. Beyond basic weekly planner 
functionalities, our Bullet Journal also comes with additional features including keyboard shortcuts to access all of 
your favorite menu bar buttons as well as a detailed view for each task and event that will appear when that task/event 
is clicked on. Not to mention, all of your weekly journal information will remain password protected at all times 
for added privacy! 
Thank you for using our product, enjoy!

  [[SOLID Principles]]
- Single Responsibility:
    - Our code follows Single Responsibility because we made sure that each class only represent/hold
      one idea and the methods within each class are related and serve purpose to that one idea. In addition,
      we made sure that methods are also abstracted into smaller helper methods and those methods are responsible
      for one task. For example, in our AbstractItem class, we have a method to retrieve the valid links of an item’s
      description. We made sure to separate validating the retrieved links to a helper method called isValidLink()
      from our main method of getValidLinks().
- Open to Extension, Closed for Modification:
    - Our implementation follows the principle of open to extension and close for modification by
      having interfaces and abstract classes that have inheritable methods, which increases the
      flexibility of having different versions of the same functionality if needed later on. For example,
      our BujoPageImp shows a weekly bujopage, but if in the future the user would like a monthly bujo page,
      a new subclass can extend the BujoPage Interface and add functionality specific to the monthly page.
      As such, every method of BujoPage Interface would be needed for a larger scaled bujopage.
- Liskov’s Substitution Principles:
    - We followed Liskov’s Substitution Principles by making sure that no subclass of any superclass, when
      replacing our superclass, will break the functionality of the program. For example, in our model, we
      made sure that all methods of our Item interface are applicable to subclass that extends/implements it.
      We also made sure to have only public methods inherited from the superclass in all of our subclass.
- Interface Segregation
    - When we initially designed our model, we had our EventItem and TaskItem both extending AbstractItem,
      which extends the Item Interface, but TaskItem does not have some getters for EventItem and vice versa.
      To follow SOLID, we implemented the EventItemInterface and TaskItemInterface such that EventItem and TaskItem
      only inherits methods that are relevant to themselves.
- Delegate Inversion
    - As per the delegate inversion principles, we made sure that our controller, view, and model have
      their own interface such that whenever needed, we can pass in different versions of our controller,
      view, and model such that the code can be tested or reused. We also instantiated model, controller,
      and view appropriately passed them in as delegates via their respective constructors so that the functionality
      of each are seperated but are accessible when needed. For example, we passed in an instance of our model
      to our controller such that when the controller is handling an event, the controller can delegate
      responsibility to our model.


