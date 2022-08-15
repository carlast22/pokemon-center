import '../styles/globals.css'

import { TasksProvider } from '../components/taskContext'

function MyApp({ Component, pageProps }) {
  return (
    <TasksProvider>
      <Component {...pageProps} />
    </TasksProvider>
  )
}

export default MyApp
