package jcanon;


/**
* jcanon/_JCanonServerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/vpc/xprojects/gaming/canon/src/tn/rnu/enit/ateliercorba/jcanon/jcanon.idl
* lundi 15 octobre 2007 19 h 43 CEST
*/

public class _JCanonServerStub extends org.omg.CORBA.portable.ObjectImpl implements jcanon.JCanonServer
{

  public int connect (jcanon.JCanonClient client)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("connect", true);
                jcanon.JCanonClientHelper.write ($out, client);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return connect (client        );
            } finally {
                _releaseReply ($in);
            }
  } // connect

  public void playerHitFire (int player)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("playerHitFire", false);
                $out.write_long (player);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                playerHitFire (player        );
            } finally {
                _releaseReply ($in);
            }
  } // playerHitFire

  public void playerMoveLeft (int player)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("playerMoveLeft", false);
                $out.write_long (player);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                playerMoveLeft (player        );
            } finally {
                _releaseReply ($in);
            }
  } // playerMoveLeft

  public void playerMoveRight (int player)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("playerMoveRight", false);
                $out.write_long (player);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                playerMoveRight (player        );
            } finally {
                _releaseReply ($in);
            }
  } // playerMoveRight

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:tn.rnu.enit.ateliercorba/jcanon/JCanonServer:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _JCanonServerStub