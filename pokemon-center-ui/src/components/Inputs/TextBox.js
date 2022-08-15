import React from 'react'

const TextBox = (props) => {
  return (
    <div>
      <label className='font-bold text-base'>{props.label}</label>
      <input 
        type={props.type}
        name={props.name}
        placeholder={props.placeholder}
        className='bg-gray-200 text-gray-900 shadow-inner rounded my-1 p-2 py-3 px-4 flex-1 w-full'
        onChange={props.onChange} />
    </div>
  )
}

export default TextBox