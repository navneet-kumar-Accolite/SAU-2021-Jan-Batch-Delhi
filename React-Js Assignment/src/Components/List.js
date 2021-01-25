import React from 'react';
import ListItem from "./ListItem";

export default class List extends React.Component {
    render() {
        const { todoList, filter, deleteTask, duplicateTask, toggleTodoMarked } = this.props;
        let showToDos = [];

        if (filter === "all") {
            showToDos = [...todoList];
        } else if (filter === "completed") {
            for (let todo of todoList) {
                if (todo.completed) {
                    showToDos.push(todo);
                } 
            }
        } else if (filter === "pending") {
            for (let todo of todoList) {
                if (!todo.completed){
                    showToDos.push(todo);
                } 
            }
        }

        return (
            <div>
                <h4>{filter.toUpperCase()} TASKS</h4>
                {showToDos ? showToDos.map(
                    (value, index) => {
                        return <ListItem key={index}
                            todo={value}
                            index={index}
                            deleteTask={deleteTask}
                            duplicateTask={duplicateTask}
                            toggleTodoMarked={toggleTodoMarked} />
                    }
                ) : null
                }
            </div>
        );
    }
}


