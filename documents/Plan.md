# **План тестирования**

**Цель плана** - описание процесса  тестирования комплексного сервиса, взаимодействующего с
СУБД и API Банка.

### **Тестовые данные:**

Сервис обрабатывает только специальные номера карт, которые даны для тестирования:

* APPROVED карта — `1111 2222 3333 4444`;
* DECLINED карта — `5555 6666 7777 8888`.

### **Чек-лист:**

<table>
    <thead>
        <tr>
            <th>Группа проверок / модуль</th>
            <th>Проверка</th>
            <th>Приоритет</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=41 align="center">Оплата по карте /Кредит по данным карты</td>
            <td rowspan=1 align="left">Валидное значение в поле "Номер карты" с использованием специального номера APPROVED карты</td>
            <td align="center">Высокий</td>
        </tr>
        <tr>
            <td align="left">Валидное значение в поле "Номер карты" с использованием специального номера DECLINED карты</td>
            <td align="center">Высокий</td>
        </tr>
        <tr>
            <td rowspan=1 align="left">Валидное значение в поле "Номер карты" с использованием 16 рандомных цифр</td>
            <td align="center">Высокий</td>
        </tr>
        <tr>
            <td align="left">Валидное значение в поле "Номер карты" с использованием 13 рандомных цифр</td>
            <td align="center">Высокий</td>
        </tr>
         <tr>
            <td align="left">Валидное значение в поле "Номер карты" с использованием 15 рандомных цифр</td>
            <td align="center">Высокий</td>
        </tr>
        <tr>
            <td align="left">Валидное значение в поле "Номер карты" с использованием 18 рандомных цифр</td>
            <td align="center">Высокий</td>
        </tr>
         <tr>
            <td align="left">Валидное значение в поле "Номер карты" с использованием 19 рандомных цифр </td>
            <td align="center">Высокий</td>
        </tr>
         <tr>
            <td align="left">Граничное значение в поле "Номер карты" с использованием одного  цифрового символа</td>
            <td align="center">Высокий</td>
        </tr>
           <tr>
            <td align="left">Граничное значение в поле "Номер карты" с использованием 20  рандомных цифр</td>
            <td align="center">Высокий</td>
        </tr>
         </tr>
           <tr>
            <td align="left">Невалидное значение в поле "Номер карты" с использованием буквенных символов</td>
            <td align="center">Средний</td>
        </tr>
          </tr>
           <tr>
            <td align="left">Невалидное значение в поле "Номер карты" с использованием спец символов</td>
            <td align="center">Средний</td>
        </tr>
         <tr>
            <td align="left">Пустое поле "Номер карты"</td>
            <td align="center">Средний</td>
        </tr>
         <tr>
            <td align="left">Валидное значение в поле "Месяц"</td>
            <td align="center">Высокий</td>
        </tr>
         <tr>
            <td align="cleft">Граничное значение в поле "Месяц" с использованием одного цифрового символа</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Граничное значение в поле "Месяц" с использованием 3 цифровых символов</td>
            <td align="center">Средний</td>
        </tr>
         <tr>
            <td align="left">Невалидное значение в поле "Месяц" с использованием буквенных символов</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "Месяц" с использованием спец символов</td>
            <td align="center">Высокий</td>
        </tr>
        <tr>
            <td align="left">Пустое поле "Месяц"</td>
            <td align="center">Средний</td>
        </tr>
         <tr>
            <td align="left">Валидное значение в поле "Год"</td>
            <td align="center">Высокий</td>
        </tr>
          <tr>
            <td align="left">Граничное значение в поле "Год" с использованием одного цифрового символа</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Граничное значение в поле "Год" с использованием 3 цифровых символов</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "Год" с указанием прошлого года</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Граничное значение в поле "Год" с указанием даты  превышающей срок действия карты "+6 лет"</td>
            <td align="center">Высокий</td>
        </tr>
         <tr>
            <td align="left">Невалидное значение в поле "Год" с использованием буквенных символов</td>
            <td align="center">Средний</td>
        </tr>
           <tr>
            <td align="left">Невалидное значение в поле "Год" с использованием спец символов</td>
            <td align="center">Средний</td>
        </tr>
         <tr>
            <td align="left">Пустое значение в поле "Год"</td>
            <td align="center">Средний</td>
        </tr> 
          <tr>
            <td align="left">Валидное значение в поле "Владелец" с указанием имени и фамилии латиницей</td>
            <td align="center">Высокий</td>
        </tr>
          <tr>
            <td align="left">Граничное значение в поле "Владелец" с использованием одного буквенного символа</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Граничное значение в поле "Владелец" с использованием 21 буквенных символов с учётом пробелов</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "Владелец" с написанием только имени латиницей</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "Владелец" с написанием имени и фамилии Кириллицей</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "Владелец" с написанием имени и фамилии через символ "-"</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "Владелец" с написанием имени и фамилии с использованием спец символов</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "Владелец" с использованием цифровых символов</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Пустое значение в поле "Владелец" </td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Валидное значение в поле "CVC/CVV"</td>
            <td align="center">Высокий</td>
        </tr>
          <tr>
            <td align="left">Граничное значение в поле "CVC/CVV" с использованием одного цифрового символа</td>
            <td align="center">Высокий</td>
        </tr>
          <tr>
            <td align="left">Граничное значение в поле "CVC/CVV" с использованием 4 цифровых символов</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "CVC/CVV" с использованием буквенных символов</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Невалидное значение в поле "CVC/CVV" с использованием спец символов</td>
            <td align="center">Средний</td>
        </tr>
          <tr>
            <td align="left">Пустое значение в поле "CVC/CVV"</td>
            <td align="center">Средний</td>
        </tr>
    </tbody>
</table>

### **Тест-кейсы (оплата по карте / Кредит по данным карты):**

<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Название (Title):</th>
            <th>Приоритет (Priority)</th>
            <th>Предусловия (Preconditions)</th>
            <th>Шаги (Steps to reproduce):</th>
            <th>Ожидаемый результат (Expected result):</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan=6 align="center">1</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием специального номера APPROVED карты</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> Сообщение "Операция одобрена Банком."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">2</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием специального номера DECLINED карты</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 5555 6666 7777 8888</td>
            <td rowspan=6 align="center">Сообщение "Ошибка! Банк отказал в проведении операции."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">3</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием тринадцати цифровых символов в поле "Номер карты"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" ввести тринадцать рандомных цифровых символов</td>
            <td rowspan=6 align="center">Сообщение "Ошибка! Банк отказал в проведении операции."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">4</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием пятнадцати цифровых символов в поле "Номер карты"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" ввести пятнадцать рандомных цифровых символов</td>
            <td rowspan=6 align="center">Сообщение "Ошибка! Банк отказал в проведении операции."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">5</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием восемнадцати цифровых символов в поле "Номер карты"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" ввести восемнадцать рандомных цифровых символов</td>
            <td rowspan=6 align="center">Сообщение "Ошибка! Банк отказал в проведении операции."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">6</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием девятнадцати цифровых символов в поле "Номер карты"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" ввести девятнадцать рандомных цифровых символов</td>
            <td rowspan=6 align="center">Сообщение "Ошибка! Банк отказал в проведении операции."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">7</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием двадцати цифровых символов в поле "Номер карты"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" ввести двадцать рандомных цифровых символов</td>
            <td rowspan=6 align="center">В поле "Номер карты" введётся 19 цифр и появится сообщение "Ошибка! Банк отказал в проведении операции."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr> 
        <tr>
            <td rowspan=6 align="center">8</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием одного цифрового символа в поле "Номер карты"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" ввести один рандомный цифровой символ</td>
            <td rowspan=6 align="center"> Под полем "Номер карты" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr> 
         <tr>
            <td align="center">9</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием буквенных символов в поле "Номер карты"</td>
            <td align="center">Высокий</td>
            <td align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" ввести буквенные символы</td>
            <td align="center"> поле "Номер карты" останется пустым</td>
        </tr>
         <tr>
            <td align="center">10</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием спец символов в поле "Номер карты"</td>
            <td align="center">Высокий</td>
            <td align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" ввести спец символы</td>
            <td align="center"> поле "Номер карты" останется пустым</td>
        </tr>
         <tr>
            <td rowspan=6 align="center">11</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием пустого поля "Номер карты"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Оставить пустое поле "Номер карты"</td>
            <td rowspan=6 align="center"> Под полем "Номер карты" появится сообщение "Поле обязательно для заполнения"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr> 
        <tr>
            <td rowspan=6 align="center">12</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием одного цифрового символа в поле "Месяц"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> Под полем "Месяц" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" одним цифровым символом</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
          <tr>
            <td rowspan=6 align="center">13</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием трёх цифровых символов в поле "Месяц"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> В поле "Месяц" введутся два циферных символа и  появится сообщение "Операция одобрена Банком."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" тремя цифровыми символами</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
           <tr>
            <td rowspan=6 align="center">14</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с введением в поле"Месяц" значения 13 </td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> Под полем "Месяц" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" значением 13</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td align="center">15</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием буквенных символов в поле "Месяц"</td>
            <td align="center">Высокий</td>
            <td align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Месяц" ввести буквенные символы</td>
            <td align="center"> поле "Месяц" останется пустым</td>
        </tr>
         <tr>
            <td align="center">16</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием спец символов в поле "Месяц"</td>
            <td align="center">Высокий</td>
            <td align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Месяц" ввести спец символы</td>
            <td align="center"> поле "Месяц" останется пустым</td>
        </tr>
          <tr>
            <td rowspan=6 align="center">17</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с пустым полем "Месяц"</td>
            <td rowspan=6 align="center">Средний</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> Под полем "Месяц" появится сообщение "Поле обязательно для заполнения"</td>
        </tr>
        <tr>
            <td align="center">Пустое поле "Месяц"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
         <tr>
            <td rowspan=6 align="center">18</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием одного цифрового символа в поле "Год"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> Под полем "Год" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" одним цифровым символом</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
         <tr>
            <td rowspan=6 align="center">19</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием трёх цифровых символов в поле "Год"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> В поле "Год" введутся два циферных символа и  появится сообщение "Операция одобрена Банком."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" тремя цифровыми символами(первые два символа должны быть равны текущему году)</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
         <tr>
            <td rowspan=6 align="center">20</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с введением в поле "Год" прошлогодней даты</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> Под полем "Год" появится сообщение "Истёк срок действия карты"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" прошлогодней датой</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr> 
         <tr>
            <td rowspan=6 align="center">21</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с введением в поле "Год" даты (плюс шесть лет к текущему году)</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> Под полем "Год" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" датой (плюс шесть лет к текущему году)</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr> 
        <tr>
            <td align="center">22</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием буквенных символов в поле "Год"</td>
            <td align="center">Высокий</td>
            <td align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Год" ввести буквенные символы</td>
            <td align="center"> поле "Год" останется пустым</td>
        </tr>
         <tr>
            <td align="center">23</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием спец символов в поле "Год"</td>
            <td align="center">Высокий</td>
            <td align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Год" ввести спец символы</td>
            <td align="center"> поле "Год" останется пустым</td>
        </tr>
         <tr>
            <td rowspan=6 align="center">24</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с пустым полем "Год"</td>
            <td rowspan=6 align="center">Средний</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center"> Под полем "Год" появится сообщение "Поле обязательно для заполнения"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Пустое поле "Год" </td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr> 
        <tr>
            <td rowspan=6 align="center">25</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием одного буквенного символа в поле "Владелец"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "Владелец" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" одним буквенным символом</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">26</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием двадцати одного буквенного символа в поле "Владелец"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "Владелец" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец"  двадцать одним буквенным символом включая пробелы</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
         <tr>
            <td rowspan=6 align="center">27</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с введением в поле "Владелец" только имени на латинице</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "Владелец" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" только именем на латинице</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">28</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с написанием в поле "Владелец" имени и фамилии кириллицей</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "Владелец" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" имени и фамилии на кириллице</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">29</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с написанием в поле "Владелец" имени и фамилии кириллицей через  символ "-"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Сообщение "Операция одобрена Банком."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" имени и фамилии через символ "-"</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">30</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с написанием в поле "Владелец" имени и фамилии, используя спецсимволы</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "Владелец" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" имени и фамилии, используя спецсимволы</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">31</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с написанием в поле "Владелец" имени и фамилии, используя цифровые символы</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "Владелец" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" имени и фамилии, используя цифровые символы</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">32</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с пустым полем "Владелец"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "Владелец" появится сообщение "Поле обязательно для заполнения"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Пустое поле "Владелец"</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" валидным значением</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">33</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием одно цифрового символа в поле "CVC/CVV"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "CVC/CVV" появится сообщение "Неверный формат"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" одним цифровым символом</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
         <tr>
            <td rowspan=6 align="center">34</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием четырёх цифровых символов в поле "CVC/CVV"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">В поле "CVC/CVV" введутся три цифровых символа и  появится сообщение "Операция одобрена Банком."</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Заполнить поле "CVC/CVV" четырьмя цифровыми символами</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        <tr>
            <td align="center">35</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием буквенных символов в поле "CVC/CVV"</td>
            <td align="center">Высокий</td>
            <td align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "CVC/CVV" ввести буквенные символы</td>
            <td align="center"> поле "CVC/CVV" останется пустым</td>
        </tr>
         <tr>
            <td align="center">36</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием спецсимволов в поле "CVC/CVV"</td>
            <td align="center">Высокий</td>
            <td align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "CVC/CVV" ввести спец символы</td>
            <td align="center"> поле "CVC/CVV" останется пустым</td>
        </tr>
        <tr>
            <td rowspan=6 align="center">37</td>
            <td rowspan=6 align="left">Оплата тура "Путешествие дня" с использованием пустого поля "CVC/CVV"</td>
            <td rowspan=6 align="center">Высокий</td>
            <td rowspan=6 align="center">Запустить SUT и открыть страницу http://localhost:8080</td>
            <td align="center">Ввести в поле "Номер карты" 1111 2222 3333 4444</td>
            <td rowspan=6 align="center">Под полем "CVC/CVV" появится сообщение "Поле обязательно для заполнения"</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Месяц" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Год" валидным значением</td>
        </tr>
        <tr>
            <td align="center">Заполнить поле "Владелец" валидным значением</td>
        </tr>
         <tr>
            <td align="center">Пустое поле "CVC/CVV"</td>
        </tr>
          <tr>
            <td align="center">Нажать на кнопку "Продолжить"</td>
        </tr>
        
 </tbody>
</table>

## **Перечень автоматизируемых сценариев**
### **UI сценарии**
#### **Предусловия:**
1. Открыть страницу http://localhost:8080
2. Нажать кнопку `Купить`, открывается `Оплата по карте`

<table>
    <thead>
        <tr>
            <th>№</th>
            <th>Отправка формы </th>
            <th>Результат</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td colspan="3" align="center">  Позитивные сценарии  </td>
        </tr>
        <tr>
            <td align="center">1</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием специального номера APPROVED карты</td>
            <td align="left">Сообщение "Операция одобрена Банком."</td>
        </tr>
        <tr>
            <td align="center">2</td>
            <td align="left">Оплата тура "Путешествие дня" с использованием специального номера DECLINED карты</td>
            <td align="left">Сообщение "Ошибка! Банк отказал в проведении операции."</td>
        </tr>
        <tr>
            <td colspan="3" align="center"> Негативны сценарии </td>
        </tr>
        tr>
            <td align="center">3</td>
            <td align="left">Поле "Номер карты"- ввод невалидных данных </td>
            <td align="left">Сообщения "Ошибка! Банк отказал в проведении операции.","Неверный формат ","Поле обязательно для заполнения "</td>
        </tr>
        tr>
            <td align="center">4</td>
            <td align="left">Поле "Месяц"- ввод невалидных данных </td>
            <td align="left">Сообщения "Неверно указан срок действия карты"," Неверный формат ","Поле обязательно для заполнения "</td>
        </tr>
        tr>
            <td align="center">5</td>
            <td align="left">Поле "Год"- ввод невалидных данных </td>
            <td align="left">Сообщения "Истёк срок действия карты ","Неверный формат ","Поле обязательно для заполнения "</td>
        </tr>
        tr>
            <td align="center">6</td>
            <td align="left">Поле "Владелец"- ввод невалидных данных </td>
            <td align="left">Сообщения "Неверный формат ","Поле обязательно для заполнения "</td>
        </tr>
         tr>
            <td align="center">7</td>
            <td align="left">Поле "CVC/CVV"- ввод невалидных данных </td>
            <td align="left">Сообщения "Неверный формат ","Поле обязательно для заполнения "</td>
        </tr>
 </tbody>
</table>

### **API сценарии**

<table>
    <thead>
        <tr>
            <th>№</th>
            <th>Отправка запроса </th>
            <th>Результат</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td align="center">1</td>
            <td align="left">POST запрос покупка тура "Путешествие дня" с валидно заполненным body и данными  APPROVED карты </td>
            <td align="left"> Появление  записи в БД, и статус 200 </td>
        </tr>
        <tr>
            <td align="center">2</td>
            <td align="left">POST запрос покупка тура "Путешествие дня" с валидно заполненным body и данными DECLINED карты </td>
            <td align="left"> Появление  записи в БД, и статус 200 </td>
        </tr>
        <tr>
            <td align="center">3</td>
            <td align="left">POST запрос покупка тура "Путешествие дня" с пустым body </td>
            <td align="left"> Отсуствие  записи в БД, и статус 400 </td>
        </tr>
          <tr>
            <td align="center">4</td>
            <td align="left">POST запрос покупка тура "Путешествие дня" с пустым значением атрибута number в body, остальные данные заполнены валидно</td>
            <td align="left"> Отсуствие  записи в БД, и статус 400 </td>
        </tr>
          <tr>
            <td align="center">5</td>
            <td align="left">POST запрос покупка тура "Путешествие дня" с пустым значением атрибута month в body, остальные данные заполнены валидно</td>
            <td align="left"> Отсуствие  записи в БД, и статус 400 </td>
        </tr>
          <tr>
            <td align="center">6</td>
            <td align="left">POST запрос покупка тура "Путешествие дня" с пустым значением атрибута year в body, остальные данные заполнены валидно</td>
            <td align="left"> Отсуствие  записи в БД, и статус 400 </td>
        </tr>
          <tr>
            <td align="center">7</td>
            <td align="left">POST запрос покупка тура "Путешествие дня" с пустым значением атрибута holder в body, остальные данные заполнены валидно</td>
            <td align="left"> Отсуствие  записи в БД, и статус 400 </td>
        </tr>
         <tr>
            <td align="center">7</td>
            <td align="left">POST запрос покупка тура "Путешествие дня" с пустым значением атрибута cvc в body, остальные данные заполнены валидно</td>
            <td align="left"> Отсуствие  записи в БД, и статус 400 </td>
        </tr>
</tbody>
</table>

## **Перечень используемых инструментов с обоснованием выбора**

1. **IDE:** ***IntelliJ IDEA*** - Самая распространённая среда для Java, которая поддерживает фреймворки
2. **Язык программирования:** ***Java*** 
3. **Система сборки:** ***Gradle***  - Легче настраивать зависимости по сравнению с Maven
4. **Тестовая среда:** ***JUnit5***  - Фреймворк, который содержит необходимые аннотации и асерты 
5. **Фреймворк для frontend тестирования:** ***Selenide*** - простой инструмент для UI тестов
6. **Фреймворки для backend тестирования:**  
   ***REST Assured***  - данный инструмент, который позволяет автоматизировать тестирование get и post запросы.
   ***DBUtils*** - данный инструмент  используется для проверки состояния БД
7.  ***Java Faker*** - данная библиотека используется как инструмент для генерации тестовых данных
8. ***Lombok***  - данный инструмент  используется для автогенерации кода
9. **Система репортинга:**  ***Allure***  - нужна для создания отчетов о тестировании и наглядного отображения прохождения тестов и ошибок
10. ***Docker*** - для развертывания  базы данных MySQL  и сервисов  приложения

## **Перечень и описание возможных рисков при автоматизации**
1. Сложности с первым запуском SUT и БД из-за недостатка знаний
2. Отсутствие документации на тестируемый сервис
3. Потеря актуальности тестов UI при любом изменении в дизайне
4. Поддрежание тестов может занять достаточно большое количество времени

## **Интервальная оценка с учётом рисков (в часах)**

<table>
    <thead>
        <tr>
            <th>№</th>
            <th>Наименование этапа  </th>
            <th>Оценка в часах</th>
        </tr>
    </thead>
    <tbody>
       <tr>
            <td align="center">1</td>
            <td align="left">Ознакомление с проектом</td>
            <td align="left"> 2 чаcа </td>
        </tr>
        <tr>
            <td align="center">2</td>
            <td align="left">Написание плана тестирования,запуск SUT</td>
            <td align="left"> 24 часа  </td>
        </tr>
        <tr>
            <td align="center">3</td>
            <td align="left">Написание авто-тестов</td>
            <td align="left"> 40 часов  </td>
        </tr>
        <tr>
            <td align="center">4</td>
            <td align="left">Оформление баг-репортов</td>
            <td align="left"> 4 часа  </td>
        </tr>
         <tr>
            <td align="center">5</td>
            <td align="left">Отчёт по результатам автоматизации </td>
            <td align="left"> 4 часа  </td>
        </tr>
         <tr>
            <td align="center">6</td>
            <td align="left">Формирование отчетов о проведенном тестировании </td>
            <td align="left"> 8 часов  </td>
        </tr>
</tbody>
</table>

## **План сдачи работ**

<table>
    <thead>
        <tr>
            <th>№</th>
            <th> Наименование работы</th>
            <th>Дата сдачи</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td align="center">1</td>
            <td align="left">Написание плана тестирования - 2 дня после запуска SUT </td>
            <td align="left">  </td>
        </tr>
    </tbody>
     <tbody>
        <tr>
            <td align="center">2</td>
            <td align="left">Написание автотестов после согласования плана тестирования</td>
            <td align="left">  </td>
        </tr>
    </tbody>
    <tbody>
        <tr>
            <td align="center">3</td>
            <td align="left">Подготовка и оформление репортов</td>
            <td align="left">  </td>
        </tr>
    </tbody>
     <tbody>
        <tr>
            <td align="center">4</td>
            <td align="left">Отчеты по тестированию и автоматизации тестирования</td>
            <td align="left">  </td>
        </tr>
    </tbody>
</table>




