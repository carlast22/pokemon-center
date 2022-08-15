import { createContext, useContext, useState } from "react";

export const TaskContext = createContext()

export const useTasks = () => useContext(TaskContext)

export const TasksProvider = ({children}) => {
    const [tasks, setTasks] = useState([{name: '---'}])  
    
const createTask = (name) => {
    setTasks([...tasks,{name}])
}

    return (
        <TaskContext.Provider value={{tasks, createTask}}>
            {children}
        </TaskContext.Provider>
    )
}