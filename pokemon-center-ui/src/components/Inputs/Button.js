import React from 'react'
import { FaSave } from 'react-icons/fa';

const Button = (props) => {

  return (
    <button 
        className="bg-red-800 hover:bg-red-900 text-white px-5 py-2 shadow-md font-bold rounded inline-flex items-center disabled:opacity-50"
        disabled={props.disabled}>
          <FaSave className='mr-4' />
            {props.text}
    </button>
  )
}

export default Button