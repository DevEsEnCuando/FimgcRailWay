import React, { useContext,useEffect} from 'react';
import axios from 'axios';
import Container from 'react-bootstrap/Container';
import { Navbar, NavDropdown, Figure } from 'react-bootstrap';
import AuthContext from '../../Context/AuthProvider';
import { useNavigate } from 'react-router-dom';


const Header = () => {
  const {user} = useContext(AuthContext)
  const navigate= useNavigate()
  const token=user.token;
  
  const handleLogout = ()=>{
    localStorage.removeItem("user")    
    window.location.reload();
   }
   useEffect(() => {
    validateToken();
  }, []);
  const validateToken = async () => {
    try {
      const response = await axios.post(
        'http://localhost:8080/login/validate-token',
        { token: token }
      );

      const isValid = response.data === 'Token is valid and not expired';

      if (!isValid) {
        handleLogout(); // Ejecutar logout solo si el token no es válido
      }
    } catch (error) {
      handleLogout(); // Ejecutar logout en caso de error
    }
  };
  
  return (
    
    <Navbar>
    <Container>
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Brand>
        <img
          src="/bannerdoc.jpg"
          height="60"
          className="d-inline-block align-top"
          alt="Banner"
        />
      </Navbar.Brand>
      <Navbar.Collapse className="justify-content-end customize-navbar-collapse">
        <NavDropdown
          title={
            <span>
              {user.nombre}{" "}
              <Figure>
                <Figure.Image className='margin-navar-icon'
                  width={33}
                  height={33}
                  src="/300px-UserIcon-FIMGC.png"
                />
              </Figure>
            </span>
          } id="basic-nav-dropdown" >
          <NavDropdown.Item href="/" onClick={handleLogout}>
            Cerrar sesión <i className="fi fi-br-address-card"></i>
          </NavDropdown.Item>
        </NavDropdown>
      </Navbar.Collapse>
    </Container>
  </Navbar>
  )
}

export default Header