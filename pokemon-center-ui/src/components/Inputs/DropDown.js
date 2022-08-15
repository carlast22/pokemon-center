import React from 'react'

const DropDown = (props) => {
  return (
    <div>
      <label className='font-bold text-base'>{props.label}</label>
      <select name={props.name} onChange={props.onChange} className="bg-gray-200 text-gray-900 shadow-inner rounded p-2 flex-1 w-full py-3 px-4">
            <option value="choose" defaultValue={0}>
            -- {props.emptyMessage} --
            </option>
            { props.items }
        </select>
    </div>
  )
}

export default DropDown