import {React, useState} from 'react'
import TextBox from '../Inputs/TextBox'
import Button from '../Inputs/Button'
import { useRouter } from 'next/dist/client/router'

const PersonFormCreate = () => {

    const router = useRouter()

    const [person, setPerson] = useState({
        name: '',
        lastName: '',
        identification: '',
        email: '',
        password: '',
        rolId: 1
    })

    const handleChange = e => {
        const {name, value} = e.target
        setPerson({...person, [name]: value})
    }

    const handleSubmit = e => {
        e.preventDefault()

        const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(person)
        };
        fetch(`${baseUrl}person/create`, requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));

        router.push("/person")
    }

  return (
    <form onSubmit={handleSubmit} className="my-2 p-10 rounded shadow-md bg-slate-900/90 text-white backdrop-blur-md">
        <h1 className='font-bold text-lg'>Trainer - Registry</h1>
        <div className='grid grid-cols-2 gap-4 my-10'>
            <TextBox type="text" name="identification" label="Identification:" onChange={handleChange} />
            <TextBox type="text" name="name" label="Name:" onChange={handleChange} />
            <TextBox type="text" name="lastName" label="Lastname:" onChange={handleChange} />
            <TextBox type="text" name="email" label="Email:" onChange={handleChange} />
            <TextBox type="password" name="password" label="Password:" onChange={handleChange} />
        </div>
        <Button text="Save" disabled={!person.identification}/>
    </form>
  )
}

export default PersonFormCreate