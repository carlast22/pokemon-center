import React from 'react'

const TextArea = (props) => {
  return (
    <textarea 
        rows="2" 
        name={props.name}
        placeholder={props.placeholder}
        className='bg-gray-800 text-white focus:text-gray-100 focus:outline-none w-full py-3 px-4 mb-5'
        onChange={props.onChange} ></textarea>
  )
}

export default TextArea