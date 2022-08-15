import {React, useState} from 'react'
import TextBox from '../Inputs/TextBox'
import Button from '../Inputs/Button'
import DropDown from '../Inputs/DropDown'
import { useRouter } from 'next/dist/client/router'

const MedicarRecordFormCreate = () => {

    const router = useRouter()

    const [medicalRecord, setMedicalRecord] = useState({
        pokemonPersonId: 0,
        doctorId: 1,
        followUpDate: '',
        observation: '',
        diagnostic: '',
    })

    const handleChange = e => {
        const {name, value} = e.target
        setMedicalRecord({...medicalRecord, [name]: value})
    }

    const handleSubmit = e => {
        e.preventDefault()

        const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(medicalRecord)
        };
        fetch(`${baseUrl}medicalRecordController/create`, requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));

        router.push("/medicalrecord")
    }

  return (
    <form onSubmit={handleSubmit} className="my-2 p-10 rounded shadow-md bg-slate-900/90 text-white backdrop-blur-md">
        <h1 className='font-bold text-lg'>Medical record - Registry</h1>
        <div className='grid grid-cols-2 gap-4 my-10'>
            <DropDown name='pokemonPersonId' onChange={handleChange} emptyMessage="Select a pokemon/trainer" label="Pokemon/Trainer:"/>
            <TextBox type="text" name="diagnostic" label="Diagnostic:" onChange={handleChange} />
            <TextBox type="text" name="observation" label="Observation:" onChange={handleChange} />
            <TextBox type="date" name="followUpDate" label="Follow up date:" onChange={handleChange} />
        </div>
        <Button text="Save" disabled={!medicalRecord.diagnostic}/>
        
    </form>
  )
}

export default MedicarRecordFormCreate