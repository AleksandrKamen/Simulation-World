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
 
 **DeadCreature** – класс реализующий мертвый/съеденный объект, отображается 1 ход 
![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/skull.png) ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/tiger_sh.png)  ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/lion_sh.png)  

## Пользовательский интерфейс  и возможности 

Взаимодействие с пользователем реализовано через выбор действия с помощью кнопок на панели снизу.
 
 
  <p align="center"> <img width="500" height="300" src = https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/1.png> </p>
  
 **1.Установка размера мира(карты)**  – отрисовка пустого мира, заданного размера.
  
      
 **2. Добавление животных** – помещает в мир объекты каждого типа, со случайными параметрами.
    

 **3. Сделать ход всеми животными** – каждый нестатический объект производит 1 ход
 
   
 **4. Запустить симуляцию**  – запускает симуляцию на заданное кол-во ходов, если количество животных падает ниже 3, в мир  добавляется несколько животных.
  

**5. Показать статистику мира** – Выводит статистику мира на текущий ход

  <p align="center"> <img width="700" height="300" src = https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Swing.Picture/bottom.png> </p>

  **6.Выход из симуляции** – Завершает работу программы. 

  



    
   
