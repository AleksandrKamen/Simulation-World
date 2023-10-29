#                                              Обзор проекта (Simulation)
<img src="https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Simulation-world-project-2023-10-29-15-02-15.gif" width="800" height="800" />


**Техническое задание проекта** -  https://zhukovsd.github.io/java-backend-learning-course/Projects/Simulation/

**Мотивация проекта** - Демонстрация принципов дизайна архитектуры приложения с помощью ООП, использование Maven для сборки проекта.
	
**Суть проекта** - пошаговая симуляция 2D мира, населённого травоядными - и хищниками. Кроме существ, мир содержит ресурсы, которыми питаются травоядные, и статичные объекты (горы и деревья), с которыми нельзя взаимодействовать - они просто занимают место.
	
##                                                   **Классы животных** 
  **Predator** - класс реализующий - хищное животное, обладает показателями скорости передвижения, количеством здоровья, сытости и силой атаки.  **Функциональные возможности** – при наличии рядом травоядного, атакует его, иначе передвигается к ближайшему. В отсутствии травоядных атакует другого хищника   ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/lion.png)  ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/tiger.png)  

 **Herbivore** - класс реализующий – травоядное животное, обладает показателями скорости передвижения, сытости и количеством здоровья.  **Функциональные возможности** – при наличии рядом ресурса, съедает его, увеличивая свое HP  иначе передвигается к ближайшему.
 ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/cow.png)  При атаки хищника истекает кровью.  ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/blood2.png) 
 
 
 ##                                                   **Класс Hunter**
Класс реализующий охотника. Охотится на класс Predator. ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/hunter.png)  

 
 ## Статические классы
 **Grass** - класс реализующий - ресурс для травоядных животных, обладает показателем питательности. 
 
![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/apple_red.png)  ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/apple_red_full.png) 
 
 **Tree** - класс реализующий  статический объект – дерево, занимает клетку на поле. После определенного времени начинает стареть, пока не исчезнет.
 
 ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/tree.png)  ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/treeSpring.png) 
 
 **Rock** - класс реализующий  статический объект - гора , занимает клетку на поле. 
 
![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/rock.png) 
 
 **DeadCreature** – класс реализующий мертвый/съеденный/убитый объект, отображается 1 ход 
![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/skull.png) ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/tiger_sh.png)  ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/lion_sh.png)  ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/deadtree2.png)  

## Пользовательский интерфейс  и возможности 

Взаимодействие с пользователем реализовано через выбор действия с помощью кнопок на панели снизу.
 
![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/bottom.PNG) 
  
**1.Start**  – Запуск Симуляции, автоматическое добавление объектов на карту. 

**2.Pause** – Ставит Симуляцию на паузу.

**3.Next turn** – Каждый нестатический объект производит 1 ход, автоматическое добавление объектов на карту. 

**4.Кнопки добавления**  – Добавляют 1 объект выбранного класса.

**5.Выход из симуляции** – Завершает работу программы. 

  



    
   
