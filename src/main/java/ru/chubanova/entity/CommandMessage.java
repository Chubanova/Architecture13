package ru.chubanova.entity;

import lombok.Data;

@Data
public class CommandMessage {
//    id игры - для идентификации игры, в рамках которой это сообщение обработано. С помощью этого id можно будет определить получателя сообщения при маршрутизации сообщения внутри игрового сервера.
//    id игрового объекта, которому адресовано сообщение. С помощью этого id можно будет определить игровой объект внутри игры, для которого адресовано это сообщение.
//    id операции - по этому id в IoC можно будет определить команду, которая будет обрабатывать данное сообщение.
//            args - вложенный json объект с параметрами операции. Содержимое этого объекта полностью зависит от команды, которая будет применяться к игровому объекту.

        long idGame;
        long idObject;
        long idOperation;
        String args[];
}
