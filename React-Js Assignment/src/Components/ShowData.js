import React from "react";
import TodoList from "./Todo/TodoList";

export default class ShowData extends React.Component {
    render() {
        const {todoList, filterBy} = this.props;
        let showTodos = [];

        if(filterBy === "showAll"){
            showTodos = [...todoList];
        } else if(filterBy === "completed") {
            for(let todo of todoList) {
                if(todo.marked)
                    showTodos.push(todo);
            }
        } else {
            for(let todo of todoList) {
                if(!todo.marked)
                    showTodos.push(todo);
            }
        }

       return (
           <div>
               {showTodos ? showTodos.map(
                   (value, index) => {
                       return <TodoList key = {index}
                       todo = {value}
                       />
                   }
               ) : null
            }
           </div>
       );
    }
}
