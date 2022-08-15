import React from 'react'

const Form = (props,{children}) => {
  return (
    <form onSubmit={props.onSubmit} className="my-2 p-10 rounded shadow-md bg-gray-700/90 text-white backdrop-blur-xl">
        {children}
    </form>
  )
}

export default Form