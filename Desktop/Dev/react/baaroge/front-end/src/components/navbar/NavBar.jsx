import React, {useState} from "react";
import "./navbar.scss";
import logo from "../../assets/logo.png";
import { Nav, NavLink, Navbar, NavItem } from "react-bootstrap";


function NavBar() {
    const menu = ["Login","Plans","About","Home"];
    const [isNavCollapsed, setIsNavCollapsed] = useState(false);

    const handleNavCollapse = () => setIsNavCollapsed(!isNavCollapsed);
    return ( 

        <>
            <Navbar collapseOnSelect expand="sm" bg="dark" variant="dark">
            <Navbar.Toggle aria-controls="navbarScroll" data-bs-toggle="collapse" data-bs-target="#navbarScroll" />
            <Navbar.Collapse id="navbarScroll">
                <Nav className="col-12 col-container">
                    <NavLink className="col-2 left logo" to="/"><img className="logoImage" src={logo} alt="logo" /></NavLink>
                    {menu.map(element =>(
                        <NavLink className="col-1 right" to={`/${element}`}>{element}</NavLink>
                    ))}  
                    
                </Nav>
            </Navbar.Collapse>     
        </Navbar>
            <nav className="col-12 col-container">
                <ul>
                    <li className="col-2 left logo">
                        <a href="/" className="logo"><img className="logoImage" src={logo} alt="logo" /></a>

                        <button class="custom-toggler navbar-toggler colapsable-nav-button" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded={!isNavCollapsed ? true : false} aria-label="Toggle navigation" onClick={handleNavCollapse}>
                            <span class="navbar-toggler-icon"></span>
                        </button>

                    </li>
                    <div className={`${isNavCollapsed ? 'collapse' : ''} navbar-collapse`} id="navbarsExample09">
                        {menu.map(element =>(
                            <li className="col-1 right"><a href="/login">{element}</a></li>
                        ))}  
                    </div>      
                </ul>
            </nav>
        
        </>
     );
}

export default NavBar;