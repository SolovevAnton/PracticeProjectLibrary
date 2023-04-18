# PracticeProjectLibrary
Small practice project about collections and random generation

## Task
Указания к выполнению задания:
•	Все классы должны удовлетворять Code Conventions for the Java Programming Language и принципам SOLID
•	В каждом классе должны быть описаны конструкторы по умолчанию, конструкторы с параметрами, инициализирующими поля классов, методы получения и установки значений в каждое из полей класса, метод toString, методы hashCode и equals

Задание:
1. Описать понятие Book – книга; с полями: название, автор, год выпуска
2. Описать понятие BookShelf - книжная полка; с полями: номер, список книг, которые лежат на книжной полке 
3. Описать понятие Library – библиотека; с полями: название, адрес, список книжных полок, присутствующие в библиотеке
4. Написать методы add в классе BookShelf и Library для добавления данных в списки
5. В классе BookShelf написать метод поиска книги по объекту  6. В классе BookShelf написать метод, который возвращает список книг заданного автора 
7. В классе Library написать методы поиска книжной полки по номеру, и отдельно по объекту  8. В классе Library написать методы поиска книги по имени (возвращает объект) и отдельно по объекту (возвращает массив из 2-х индексов) 9. Написать методы удаления в BookShelf и в Library элементов, которые хранят списки этих классов
10. Написать класс Generator , который содержит методы: 
•	Генерация случайного числа в диапазоне от а до b 
•	Генерация случайной книги со случайными названием, автором, годом, взятых из заранее подготовленных списков 
•	Генерация случайной книжной полки со случайным количеством книг на ней
•	Генерация библиотеки со случайным количеством книжных полок  

## Вопросы
1. Как создать enum с листами для случайного создания