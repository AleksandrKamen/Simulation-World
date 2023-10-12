#                                              Обзор проекта (Simulation)
<p align="center"> <img width="1000" height="700" src="https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Сим.jpg"> </p>


**Техническое задание проекта** -  https://zhukovsd.github.io/java-backend-learning-course/Projects/Simulation/
	
**Суть проекта** - пошаговая симуляция 2D мира, населённого травоядными - и хищниками. Кроме существ, мир содержит ресурсы, которыми питаются травоядные, и статичные объекты (горы и деревья), с которыми нельзя взаимодействовать - они просто занимают место.
	
##                                                   **Классы животных** 
  **Predator** - класс реализующий - хищное животное, обладает показателями скорости передвижения, количеством здоровья, сытости и силой атаки.  **Функциональные возможности** – при наличии рядом травоядного, атакует его, иначе передвигается к ближайшему. В отсутствии травоядных атакует другого хищника
  
 ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Predator.png)  

 **Herbivore** - класс реализующий – травоядное животное, обладает показателями скорости передвижения, сытости и количеством здоровья.  **Функциональные возможности** – при наличии рядом ресурса, съедает его, увеличивая свое HP  иначе передвигается к ближайшему.
 
 ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Herb.png)  При атаки хищника истекает кровью. ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Herb2.png) 
 ## Статические классы
 **Grass** - класс реализующий - ресурс для травоядных животных, обладает показателем питательности. 
 ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Grass.png) 
 
 **Tree** - класс реализующий  статический объект – дерево, занимает клетку на поле. 
 ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/Tree.png) 
 
 **Rock** - класс реализующий  статический объект - гора , занимает клетку на поле. 
 ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/rook.png) 
 
 **DeadCreature** – класс реализующий мертвый/съеденный объект, отображается 1 ход ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/ch.png)  ![Image alt](https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/ch2.png) 
 ## Пользовательский интерфейс  и возможности 
 Взаимодействие с пользователем реализовано через выбор действия (1-6).
 
  <p align="center"> <img width="500" height="300" src = https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/1.png> </p>
  
 **1.Установка размера мира(карты)**  – отрисовка пустого мира, заданного размера.
  
      
 **2. Добавление животных** – помещает в мир объекты каждого типа, со случайными параметрами.
    

 **3. Сделать ход всеми животными** – каждый нестатический объект производит 1 ход
 
   
 **4. Запустить симуляцию**  – запускает симуляцию на заданное кол-во ходов, если количество животных падает ниже 3, в мир  добавляется несколько животных.
  

**5. Показать статистику мира** – Выводит статистику мира на текущий ход

  <p align="center"> <img width="700" height="300" src = https://github.com/AleksandrKamen/Simulation-World/blob/master/Picture/7.png> </p>

  **6.Выход из симуляции** – Завершает работу программы. 

  
Просьба оставлять отзывы и замечания  на проект, заранее спасибо!
Благодарность за обучение и предоставленные материалы - https://t.me/zhukovsd_it_mentor


    
   