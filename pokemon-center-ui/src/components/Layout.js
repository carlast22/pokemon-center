import Link from "next/link"
import { useRouter } from "next/router"

const Layout = ({children}) => {

    const router = useRouter();

    const menuItems = [
        {
          href: '/',
          title: 'Home',
        },
        {
          href: '/pokemon',
          title: 'Pokemon',
        },
        {
          href: '/person',
          title: 'Trainer',
        },
        {
          href: '/pokperson',
          title: 'Pokemon & Trainer',
        },
        {
          href: '/medicalrecord',
          title: 'Medical Record',
        },
      ];

  return (
    <div className='min-h-screen flex flex-col'>
      <header className='text-2xl bg-gradient-to-b from-slate-900 to-slate-800 text-white shadow-md sticky top-0 h-14 flex justify-center items-center font-semibold uppercase'>
        Pokemon Center
      </header>
      <div className='flex flex-col md:flex-row flex-1'>
        <aside className='bg-gradient-to-b from-slate-900 to-slate-800 shadow-md w-full md:w-60'>
          <nav>
            <ul>
              {menuItems.map(({ href, title }) => (
                <li className='m-2' key={title}>
                  <Link href={href}>
                    <a
                      className={`flex p-2 bg-gradient-to-r from-slate-800 to-slate-700 text-white rounded hover:shadow-lg cursor-pointer ${
                        router.asPath === href && 'text-red-600 font-bold'
                      }`}
                    >
                      {title}
                    </a>
                  </Link>
                </li>
              ))}
            </ul>
          </nav>
        </aside>
        <main className='flex-1 lg:px-96 md:px-50 px-5 py-5 md:bg-cover sm:bg-auto bg-pokeball'>{children}</main>
      </div>
    </div>
  )
}

export default Layout