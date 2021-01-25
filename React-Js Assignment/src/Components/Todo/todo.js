import React from "react";
import InputText from "../InputText";
import List from "../List";
import Button from "../Button";


class Todo extends React.Component {

    state = {
      inputFieldValue: "",
      todoList: [{ task: "Create a Todo List", completed: false }],
      filter: "all" // all, completed, pending
    };
  
    updateInputField = (event) => {
      // console.log(event.target.value);
      this.setState({ inputFieldValue: event.target.value });
    }
  
    addTodo = () => {
      // console.log('inside addTodo',this.state.todoList);
      const { inputFieldValue, todoList } = this.state;
      let newTodos = [...todoList];
      if (inputFieldValue !== "") {
        newTodos.push({ task: inputFieldValue, completed: false });
        this.setState({ todoList: newTodos, inputFieldValue: "" });
      }
    }
  
    deleteTask = (index) => {
      const { todoList } = this.state;
      let tempArr = [...todoList];
      tempArr.splice(index, 1);
      this.setState({ todoList: tempArr });
    }
  
    duplicateTask = (index) => {
      const { todoList } = this.state;
      let tempArr = [...todoList];
      tempArr.push({ task: tempArr[index].task, completed: false })
      this.setState({ todoList: tempArr });
    }
  
    toggleTodoMarked = (index) => {
      const todos = this.state.todoList;
      let newTodos = [...todos]; //spread
      // newTodos[index] = {
      //     ...newTodos[index],
      //     completed: !newTodos[index].completed
      // } ;
      newTodos[index].completed = !newTodos[index].completed;
      this.setState({ todoList: newTodos });
    }
  
    displayAll = () => {
      this.setState({ filter: "all" });
    }
  
    displayCompleted = () => {
      this.setState({ filter: "completed" });
    }
  
    displayPending = () => {
      this.setState({ filter: "pending" });
    }
  
    render() {
      return (
        <div class="d-flex flex-column justify-content-around align-content-center m-4 bg-light" style={{ fontFamily: "roboto" }}>
          <h1 class="text-center">Todo List</h1>
          <InputText value={this.state.inputFieldValue} onChange={this.updateInputField} placeholder="Enter new Task" />
          <div>
            <Button ButtonValue="Add Todo" onClick={this.addTodo} Class="btn btn-sm btn-success col-md-2" />
            <Button ButtonValue="Display All Tasks" onClick={this.displayAll} Class="btn btn-sm btn-warning col-md-2" />
            <Button ButtonValue="Display Complete Tasks" onClick={this.displayCompleted} Class="btn btn-sm btn-warning col-md-2" />
            <Button ButtonValue="Display Pending Tasks" onClick={this.displayPending} Class="btn btn-sm btn-warning col-md-2" />
          </div>
  
          <List todoList={this.state.todoList}
            filter={this.state.filter}
            deleteTask={this.deleteTask}
            duplicateTask={this.duplicateTask}
            toggleTodoMarked={this.toggleTodoMarked} />
        </div>
      );
    }
  }
  
  export default Todo;