package net.thevpc.gaming.atom.examples.pong.main.shared.dal.corba.generated;


/**
 * tn/edu/eniso/pong/main/shared/dal/corba/generated/ModelCorba.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from DalCorba.idl
 * Tuesday, December 20, 2011 11:10:02 PM CET
 */

public final class ModelCorba implements org.omg.CORBA.portable.IDLEntity {
    public long frame = (long) 0;
    public SpriteCorba ball = null;
    public SpriteCorba paddle1 = null;
    public SpriteCorba paddle2 = null;

    public ModelCorba() {
    } // ctor

    public ModelCorba(long _frame, SpriteCorba _ball, SpriteCorba _paddle1, SpriteCorba _paddle2) {
        frame = _frame;
        ball = _ball;
        paddle1 = _paddle1;
        paddle2 = _paddle2;
    } // ctor

} // class ModelCorba